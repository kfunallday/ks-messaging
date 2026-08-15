package com.ksmessaging.headless.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.BadRequestResponse
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse
import org.bouncycastle.util.encoders.Base64
import org.bouncycastle.util.encoders.DecoderException
import org.briarproject.bramble.api.contact.Contact
import org.briarproject.bramble.api.contact.ContactId
import org.briarproject.bramble.api.contact.ContactManager
import org.briarproject.bramble.api.db.DatabaseExecutor
import org.briarproject.bramble.api.db.NoSuchContactException
import org.briarproject.bramble.api.event.Event
import org.briarproject.bramble.api.event.EventListener
import org.briarproject.bramble.api.sync.MessageId
import org.briarproject.bramble.api.sync.event.MessagesAckedEvent
import org.briarproject.bramble.api.sync.event.MessagesSentEvent
import org.briarproject.bramble.api.system.Clock
import org.briarproject.bramble.util.StringUtils.utf8IsTooLong
import com.ksmessaging.api.blog.BlogInvitationRequest
import com.ksmessaging.api.blog.BlogInvitationResponse
import com.ksmessaging.api.conversation.ConversationManager
import com.ksmessaging.api.conversation.ConversationMessageVisitor
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent
import com.ksmessaging.api.forum.ForumInvitationRequest
import com.ksmessaging.api.forum.ForumInvitationResponse
import com.ksmessaging.api.introduction.IntroductionRequest
import com.ksmessaging.api.introduction.IntroductionResponse
import com.ksmessaging.api.messaging.MessagingConstants.MAX_PRIVATE_MESSAGE_TEXT_LENGTH
import com.ksmessaging.api.messaging.MessagingManager
import com.ksmessaging.api.messaging.PrivateMessageFactory
import com.ksmessaging.api.messaging.PrivateMessageHeader
import com.ksmessaging.api.privategroup.invitation.GroupInvitationRequest
import com.ksmessaging.api.privategroup.invitation.GroupInvitationResponse
import com.ksmessaging.headless.event.WebSocketController
import com.ksmessaging.headless.event.output
import com.ksmessaging.headless.getContactIdFromPathParam
import com.ksmessaging.headless.getFromJson
import com.ksmessaging.headless.json.JsonDict
import java.util.concurrent.Executor
import javax.annotation.concurrent.Immutable
import javax.inject.Inject
import javax.inject.Singleton

internal const val EVENT_CONVERSATION_MESSAGE = "ConversationMessageReceivedEvent"
internal const val EVENT_MESSAGES_ACKED = "MessagesAckedEvent"
internal const val EVENT_MESSAGES_SENT = "MessagesSentEvent"

@Immutable
@Singleton
internal class MessagingControllerImpl
@Inject
constructor(
    private val messagingManager: MessagingManager,
    private val conversationManager: ConversationManager,
    private val privateMessageFactory: PrivateMessageFactory,
    private val contactManager: ContactManager,
    private val webSocketController: WebSocketController,
    @DatabaseExecutor private val dbExecutor: Executor,
    private val objectMapper: ObjectMapper,
    private val clock: Clock
) : MessagingController, EventListener {

    override fun list(ctx: Context): Context {
        val contact = getContact(ctx)
        val jsonVisitor = JsonVisitor(contact.id, messagingManager)
        val messages = conversationManager.getMessageHeaders(contact.id)
            .sortedBy { it.timestamp }
            .map { header -> header.accept(jsonVisitor) }
        return ctx.json(messages)
    }

    override fun write(ctx: Context): Context {
        val contact = getContact(ctx)

        val text = ctx.getFromJson(objectMapper, "text")
        if (utf8IsTooLong(text, MAX_PRIVATE_MESSAGE_TEXT_LENGTH))
            throw BadRequestResponse("Message text is too long")

        val group = messagingManager.getContactGroup(contact)
        val now = clock.currentTimeMillis()
        val m = privateMessageFactory.createLegacyPrivateMessage(group.id, now, text)

        messagingManager.addLocalMessage(m)
        return ctx.json(m.output(contact.id, text))
    }

    override fun markMessageRead(ctx: Context): Context {
        val contact = getContact(ctx)
        val groupId = messagingManager.getContactGroup(contact).id

        val messageIdString = ctx.getFromJson(objectMapper, "messageId")
        val messageId = deserializeMessageId(messageIdString)
        conversationManager.setReadFlag(groupId, messageId, true)
        return ctx.json(messageIdString)
    }

    private fun deserializeMessageId(idString: String): MessageId {
        val idBytes = try {
            Base64.decode(idString)
        } catch (e: DecoderException) {
            throw NotFoundResponse()
        }
        if (idBytes.size != MessageId.LENGTH) throw NotFoundResponse()
        return MessageId(idBytes)
    }

    override fun deleteAllMessages(ctx: Context): Context {
        val contactId = ctx.getContactIdFromPathParam()
        try {
            val result = conversationManager.deleteAllMessages(contactId)
            return ctx.json(result.output())
        } catch (e: NoSuchContactException) {
            throw NotFoundResponse()
        }
    }

    override fun eventOccurred(e: Event) {
        when (e) {
            is ConversationMessageReceivedEvent<*> -> {
                val h = e.messageHeader
                if (h is PrivateMessageHeader) dbExecutor.execute {
                    val text = messagingManager.getMessageText(h.id)
                    webSocketController.sendEvent(EVENT_CONVERSATION_MESSAGE, e.output(text))
                } else {
                    webSocketController.sendEvent(EVENT_CONVERSATION_MESSAGE, e.output())
                }
            }
            is MessagesSentEvent -> {
                webSocketController.sendEvent(EVENT_MESSAGES_SENT, e.output())
            }
            is MessagesAckedEvent -> {
                webSocketController.sendEvent(EVENT_MESSAGES_ACKED, e.output())
            }
        }
    }

    private fun getContact(ctx: Context): Contact {
        val contactId = ctx.getContactIdFromPathParam()
        return try {
            contactManager.getContact(contactId)
        } catch (e: NoSuchContactException) {
            throw NotFoundResponse()
        }
    }
}

private class JsonVisitor(
    private val contactId: ContactId,
    private val messagingManager: MessagingManager
) : ConversationMessageVisitor<JsonDict> {

    override fun visitPrivateMessageHeader(h: PrivateMessageHeader) =
        h.output(contactId, messagingManager.getMessageText(h.id))

    override fun visitBlogInvitationRequest(r: BlogInvitationRequest) = r.output(contactId)

    override fun visitBlogInvitationResponse(r: BlogInvitationResponse) = r.output(contactId)

    override fun visitForumInvitationRequest(r: ForumInvitationRequest) = r.output(contactId)

    override fun visitForumInvitationResponse(r: ForumInvitationResponse) = r.output(contactId)

    override fun visitGroupInvitationRequest(r: GroupInvitationRequest) = r.output(contactId)

    override fun visitGroupInvitationResponse(r: GroupInvitationResponse) = r.output(contactId)

    override fun visitIntroductionRequest(r: IntroductionRequest) = r.output(contactId)

    override fun visitIntroductionResponse(r: IntroductionResponse) = r.output(contactId)
}
