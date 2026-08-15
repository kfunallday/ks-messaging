package com.ksmessaging.headless.event

import com.ksmessaging.api.blog.BlogInvitationRequest
import com.ksmessaging.api.blog.BlogInvitationResponse
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent
import com.ksmessaging.api.forum.ForumInvitationRequest
import com.ksmessaging.api.forum.ForumInvitationResponse
import com.ksmessaging.api.introduction.IntroductionRequest
import com.ksmessaging.api.introduction.IntroductionResponse
import com.ksmessaging.api.messaging.PrivateMessageHeader
import com.ksmessaging.api.privategroup.invitation.GroupInvitationRequest
import com.ksmessaging.api.privategroup.invitation.GroupInvitationResponse
import com.ksmessaging.headless.json.JsonDict
import com.ksmessaging.headless.messaging.output
import javax.annotation.concurrent.Immutable

@Immutable
@Suppress("unused")
internal class OutputEvent(val name: String, val data: JsonDict) {
    val type = "event"
}

internal fun ConversationMessageReceivedEvent<*>.output(text: String?): JsonDict {
    check(messageHeader is PrivateMessageHeader)
    return (messageHeader as PrivateMessageHeader).output(contactId, text)
}

internal fun ConversationMessageReceivedEvent<*>.output() = when (messageHeader) {
    // requests
    is ForumInvitationRequest -> (messageHeader as ForumInvitationRequest).output(contactId)
    is BlogInvitationRequest -> (messageHeader as BlogInvitationRequest).output(contactId)
    is GroupInvitationRequest -> (messageHeader as GroupInvitationRequest).output(contactId)
    is IntroductionRequest -> (messageHeader as IntroductionRequest).output(contactId)
    // responses
    is ForumInvitationResponse -> (messageHeader as ForumInvitationResponse).output(contactId)
    is BlogInvitationResponse -> (messageHeader as BlogInvitationResponse).output(contactId)
    is GroupInvitationResponse -> (messageHeader as GroupInvitationResponse).output(contactId)
    is IntroductionResponse -> (messageHeader as IntroductionResponse).output(contactId)
    // unknown
    else -> throw IllegalStateException()
}
