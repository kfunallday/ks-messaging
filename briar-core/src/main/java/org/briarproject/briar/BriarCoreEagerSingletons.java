package com.ksmessaging;

import com.ksmessaging.autodelete.AutoDeleteModule;
import com.ksmessaging.avatar.AvatarModule;
import com.ksmessaging.blog.BlogModule;
import com.ksmessaging.conversation.ConversationModule;
import com.ksmessaging.feed.FeedModule;
import com.ksmessaging.forum.ForumModule;
import com.ksmessaging.identity.IdentityModule;
import com.ksmessaging.introduction.IntroductionModule;
import com.ksmessaging.messaging.MessagingModule;
import com.ksmessaging.privategroup.PrivateGroupModule;
import com.ksmessaging.privategroup.invitation.GroupInvitationModule;
import com.ksmessaging.sharing.SharingModule;

public interface BriarCoreEagerSingletons {

	void inject(AutoDeleteModule.EagerSingletons init);

	void inject(AvatarModule.EagerSingletons init);

	void inject(BlogModule.EagerSingletons init);

	void inject(ConversationModule.EagerSingletons init);

	void inject(FeedModule.EagerSingletons init);

	void inject(ForumModule.EagerSingletons init);

	void inject(GroupInvitationModule.EagerSingletons init);

	void inject(IdentityModule.EagerSingletons init);

	void inject(IntroductionModule.EagerSingletons init);

	void inject(MessagingModule.EagerSingletons init);

	void inject(PrivateGroupModule.EagerSingletons init);

	void inject(SharingModule.EagerSingletons init);

	class Helper {

		public static void injectEagerSingletons(BriarCoreEagerSingletons c) {
			c.inject(new AutoDeleteModule.EagerSingletons());
			c.inject(new AvatarModule.EagerSingletons());
			c.inject(new BlogModule.EagerSingletons());
			c.inject(new ConversationModule.EagerSingletons());
			c.inject(new FeedModule.EagerSingletons());
			c.inject(new ForumModule.EagerSingletons());
			c.inject(new GroupInvitationModule.EagerSingletons());
			c.inject(new MessagingModule.EagerSingletons());
			c.inject(new PrivateGroupModule.EagerSingletons());
			c.inject(new SharingModule.EagerSingletons());
			c.inject(new IdentityModule.EagerSingletons());
			c.inject(new IntroductionModule.EagerSingletons());
		}
	}
}
