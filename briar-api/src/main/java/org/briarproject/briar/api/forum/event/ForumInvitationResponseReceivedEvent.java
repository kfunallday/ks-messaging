package com.ksmessaging.api.forum.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import com.ksmessaging.api.forum.ForumInvitationResponse;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class ForumInvitationResponseReceivedEvent extends
		ConversationMessageReceivedEvent<ForumInvitationResponse> {

	public ForumInvitationResponseReceivedEvent(
			ForumInvitationResponse response, ContactId contactId) {
		super(response, contactId);
	}

}
