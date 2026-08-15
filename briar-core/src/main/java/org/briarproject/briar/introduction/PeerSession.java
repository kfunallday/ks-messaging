package com.ksmessaging.introduction;

import org.briarproject.bramble.api.sync.GroupId;
import org.briarproject.bramble.api.sync.MessageId;
import com.ksmessaging.api.client.SessionId;
import org.briarproject.nullsafety.NotNullByDefault;

import javax.annotation.Nullable;

@NotNullByDefault
interface PeerSession {

	SessionId getSessionId();

	GroupId getContactGroupId();

	long getLocalTimestamp();

	@Nullable
	MessageId getLastLocalMessageId();

	@Nullable
	MessageId getLastRemoteMessageId();

}
