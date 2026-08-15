package com.ksmessaging;

import com.ksmessaging.attachment.AttachmentModule;
import com.ksmessaging.autodelete.AutoDeleteModule;
import com.ksmessaging.avatar.AvatarModule;
import com.ksmessaging.blog.BlogModule;
import com.ksmessaging.client.BriarClientModule;
import com.ksmessaging.conversation.ConversationModule;
import com.ksmessaging.feed.FeedModule;
import com.ksmessaging.forum.ForumModule;
import com.ksmessaging.identity.IdentityModule;
import com.ksmessaging.introduction.IntroductionModule;
import com.ksmessaging.messaging.MessagingModule;
import com.ksmessaging.privategroup.PrivateGroupModule;
import com.ksmessaging.privategroup.invitation.GroupInvitationModule;
import com.ksmessaging.sharing.SharingModule;
import com.ksmessaging.test.TestModule;

import dagger.Module;

@Module(includes = {
		AttachmentModule.class,
		AutoDeleteModule.class,
		AvatarModule.class,
		BlogModule.class,
		BriarClientModule.class,
		ConversationModule.class,
		FeedModule.class,
		ForumModule.class,
		GroupInvitationModule.class,
		IdentityModule.class,
		IntroductionModule.class,
		MessagingModule.class,
		PrivateGroupModule.class,
		SharingModule.class,
		TestModule.class
})
public class BriarCoreModule {
}
