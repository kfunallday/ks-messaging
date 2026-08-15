package com.ksmessaging.api.privategroup.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationResponse;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class GroupInvitationResponseReceivedEvent
		extends ConversationMessageReceivedEvent<GroupInvitationResponse> {

	public GroupInvitationResponseReceivedEvent(
			GroupInvitationResponse response, ContactId contactId) {
		super(response, contactId);
	}
}
