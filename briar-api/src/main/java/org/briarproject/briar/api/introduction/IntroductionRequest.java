package com.ksmessaging.api.introduction;

import org.briarproject.bramble.api.identity.Author;
import org.briarproject.bramble.api.sync.GroupId;
import org.briarproject.bramble.api.sync.MessageId;
import com.ksmessaging.api.client.SessionId;
import com.ksmessaging.api.conversation.ConversationMessageVisitor;
import com.ksmessaging.api.conversation.ConversationRequest;
import com.ksmessaging.api.identity.AuthorInfo;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@NotNullByDefault
public class IntroductionRequest extends ConversationRequest<Author> {

	private final AuthorInfo authorInfo;

	public IntroductionRequest(MessageId messageId, GroupId groupId, long time,
			boolean local, boolean read, boolean sent, boolean seen,
			SessionId sessionId, Author author, @Nullable String text,
			boolean answered, AuthorInfo authorInfo, long autoDeleteTimer) {
		super(messageId, groupId, time, local, read, sent, seen, sessionId,
				author, text, answered, autoDeleteTimer);
		this.authorInfo = authorInfo;
	}

	@Nullable
	public String getAlias() {
		return authorInfo.getAlias();
	}

	public boolean isContact() {
		return authorInfo.getStatus().isContact();
	}

	@Override
	public <T> T accept(ConversationMessageVisitor<T> v) {
		return v.visitIntroductionRequest(this);
	}
}
