package com.ksmessaging.api.introduction.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import com.ksmessaging.api.introduction.IntroductionRequest;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class IntroductionRequestReceivedEvent
		extends ConversationMessageReceivedEvent<IntroductionRequest> {

	public IntroductionRequestReceivedEvent(
			IntroductionRequest introductionRequest, ContactId contactId) {
		super(introductionRequest, contactId);
	}

}
