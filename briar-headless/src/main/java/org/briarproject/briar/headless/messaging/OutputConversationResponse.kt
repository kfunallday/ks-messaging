package com.ksmessaging.headless.messaging

import org.briarproject.bramble.api.contact.ContactId
import org.briarproject.bramble.identity.output
import com.ksmessaging.api.blog.BlogInvitationResponse
import com.ksmessaging.api.conversation.ConversationMessageHeader
import com.ksmessaging.api.conversation.ConversationResponse
import com.ksmessaging.api.forum.ForumInvitationResponse
import com.ksmessaging.api.introduction.IntroductionResponse
import com.ksmessaging.api.privategroup.invitation.GroupInvitationResponse
import com.ksmessaging.api.sharing.InvitationResponse
import com.ksmessaging.headless.json.JsonDict

internal fun ConversationResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as ConversationMessageHeader).output(contactId)
    dict.putAll(
        "sessionId" to sessionId.bytes,
        "accepted" to wasAccepted()
    )
    return dict
}

internal fun IntroductionResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as ConversationResponse).output(contactId)
    dict.putAll(
        "type" to "IntroductionResponse",
        "introducedAuthor" to introducedAuthor.output(),
        "introducer" to isIntroducer
    )
    return dict
}

internal fun InvitationResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as ConversationResponse).output(contactId)
    dict["shareableId"] = shareableId.bytes
    return dict
}

internal fun BlogInvitationResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as InvitationResponse).output(contactId)
    dict["type"] = "BlogInvitationResponse"
    return dict
}

internal fun ForumInvitationResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as InvitationResponse).output(contactId)
    dict["type"] = "ForumInvitationResponse"
    return dict
}

internal fun GroupInvitationResponse.output(contactId: ContactId): JsonDict {
    val dict = (this as InvitationResponse).output(contactId)
    dict["type"] = "GroupInvitationResponse"
    return dict
}
