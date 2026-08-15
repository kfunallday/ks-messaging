package com.ksmessaging.api.sharing;

import org.briarproject.bramble.api.sync.GroupId;
import org.briarproject.bramble.api.sync.MessageId;
import com.ksmessaging.api.client.SessionId;
import com.ksmessaging.api.conversation.ConversationRequest;

import javax.annotation.Nullable;

public abstract class InvitationRequest<S extends Shareable> extends
		ConversationRequest<S> {

	private final boolean canBeOpened;

	public InvitationRequest(MessageId messageId, GroupId groupId, long time,
			boolean local, boolean read, boolean sent, boolean seen,
			SessionId sessionId, S object, @Nullable String text,
			boolean available, boolean canBeOpened, long autoDeleteTimer) {
		super(messageId, groupId, time, local, read, sent, seen, sessionId,
				object, text, !available, autoDeleteTimer);
		this.canBeOpened = canBeOpened;
	}

	public boolean canBeOpened() {
		return canBeOpened;
	}
}
