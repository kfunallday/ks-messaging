package com.ksmessaging.api.conversation;

import com.ksmessaging.api.blog.BlogInvitationRequest;
import com.ksmessaging.api.blog.BlogInvitationResponse;
import com.ksmessaging.api.forum.ForumInvitationRequest;
import com.ksmessaging.api.forum.ForumInvitationResponse;
import com.ksmessaging.api.introduction.IntroductionRequest;
import com.ksmessaging.api.introduction.IntroductionResponse;
import com.ksmessaging.api.messaging.PrivateMessageHeader;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationRequest;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationResponse;
import org.briarproject.nullsafety.NotNullByDefault;

@NotNullByDefault
public interface ConversationMessageVisitor<T> {

	T visitPrivateMessageHeader(PrivateMessageHeader h);

	T visitBlogInvitationRequest(BlogInvitationRequest r);

	T visitBlogInvitationResponse(BlogInvitationResponse r);

	T visitForumInvitationRequest(ForumInvitationRequest r);

	T visitForumInvitationResponse(ForumInvitationResponse r);

	T visitGroupInvitationRequest(GroupInvitationRequest r);

	T visitGroupInvitationResponse(GroupInvitationResponse r);

	T visitIntroductionRequest(IntroductionRequest r);

	T visitIntroductionResponse(IntroductionResponse r);
}
