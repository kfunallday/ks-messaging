package com.ksmessaging.api.introduction.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import com.ksmessaging.api.introduction.IntroductionResponse;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class IntroductionResponseReceivedEvent extends
		ConversationMessageReceivedEvent<IntroductionResponse> {

	public IntroductionResponseReceivedEvent(
			IntroductionResponse introductionResponse, ContactId contactId) {
		super(introductionResponse, contactId);
	}

}
