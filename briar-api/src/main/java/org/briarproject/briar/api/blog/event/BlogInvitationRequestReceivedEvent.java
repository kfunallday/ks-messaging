package com.ksmessaging.api.blog.event;

import org.briarproject.bramble.api.contact.ContactId;
import com.ksmessaging.api.blog.Blog;
import com.ksmessaging.api.conversation.ConversationRequest;
import com.ksmessaging.api.conversation.event.ConversationMessageReceivedEvent;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class BlogInvitationRequestReceivedEvent extends
		ConversationMessageReceivedEvent<ConversationRequest<Blog>> {

	public BlogInvitationRequestReceivedEvent(ConversationRequest<Blog> request,
			ContactId contactId) {
		super(request, contactId);
	}

}
