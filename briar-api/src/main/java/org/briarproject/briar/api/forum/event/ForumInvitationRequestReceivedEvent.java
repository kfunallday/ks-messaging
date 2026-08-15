package com.ksmessaging.api.forum.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.conversation.ConversationRequest;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import com.ksmessaging.api.forum.Forum;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class ForumInvitationRequestReceivedEvent extends
		ConversationMessageReceivedEvent<ConversationRequest<Forum>> {

	public ForumInvitationRequestReceivedEvent(ConversationRequest<Forum> request,
			ContactId contactId) {
		super(request, contactId);
	}

}
