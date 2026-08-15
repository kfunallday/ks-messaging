package com.ksmessaging.test;

import org.briarproject.bramble.BrambleCoreIntegrationTestEagerSingletons;
import org.briarproject.bramble.BrambleCoreModule;
import org.briarproject.bramble.api.contact.ContactManager;
import org.briarproject.bramble.api.db.DatabaseComponent;
import org.briarproject.bramble.api.identity.AuthorFactory;
import org.briarproject.bramble.api.lifecycle.LifecycleManager;
import org.briarproject.bramble.api.properties.TransportPropertyManager;
import org.briarproject.bramble.api.system.Clock;
import org.briarproject.bramble.mailbox.ModularMailboxModule;
import org.briarproject.bramble.test.BrambleCoreIntegrationTestModule;
import org.briarproject.bramble.test.BrambleIntegrationTestComponent;
import org.briarproject.bramble.test.TestDnsModule;
import org.briarproject.bramble.test.TestPluginConfigModule;
import org.briarproject.bramble.test.TestSocksModule;
import org.briarproject.bramble.test.TimeTravel;
import com.ksmessaging.api.attachment.AttachmentReader;
import com.ksmessaging.api.autodelete.AutoDeleteManager;
import com.ksmessaging.api.avatar.AvatarManager;
import com.ksmessaging.api.blog.BlogFactory;
import com.ksmessaging.api.blog.BlogManager;
import com.ksmessaging.api.blog.BlogSharingManager;
import com.ksmessaging.api.client.MessageTracker;
import com.ksmessaging.api.conversation.ConversationManager;
import com.ksmessaging.api.forum.ForumManager;
import com.ksmessaging.api.forum.ForumSharingManager;
import com.ksmessaging.api.introduction.IntroductionManager;
import com.ksmessaging.api.messaging.MessagingManager;
import com.ksmessaging.api.messaging.PrivateMessageFactory;
import com.ksmessaging.api.privategroup.PrivateGroupManager;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationFactory;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationManager;
import com.ksmessaging.attachment.AttachmentModule;
import com.ksmessaging.autodelete.AutoDeleteModule;
import com.ksmessaging.avatar.AvatarModule;
import com.ksmessaging.blog.BlogModule;
import com.ksmessaging.client.BriarClientModule;
import com.ksmessaging.conversation.ConversationModule;
import com.ksmessaging.forum.ForumModule;
import com.ksmessaging.identity.IdentityModule;
import com.ksmessaging.introduction.IntroductionModule;
import com.ksmessaging.messaging.MessagingModule;
import com.ksmessaging.privategroup.PrivateGroupModule;
import com.ksmessaging.privategroup.invitation.GroupInvitationModule;
import com.ksmessaging.sharing.SharingModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
		BrambleCoreIntegrationTestModule.class,
		BrambleCoreModule.class,
		AttachmentModule.class,
		AutoDeleteModule.class,
		AvatarModule.class,
		BlogModule.class,
		BriarClientModule.class,
		ConversationModule.class,
		ForumModule.class,
		GroupInvitationModule.class,
		IdentityModule.class,
		IntroductionModule.class,
		MessagingModule.class,
		PrivateGroupModule.class,
		SharingModule.class,
		ModularMailboxModule.class,
		TestDnsModule.class,
		TestSocksModule.class,
		TestPluginConfigModule.class,
})
public interface BriarIntegrationTestComponent
		extends BrambleIntegrationTestComponent {

	void inject(BriarIntegrationTest<BriarIntegrationTestComponent> init);

	void inject(AutoDeleteModule.EagerSingletons init);

	void inject(AvatarModule.EagerSingletons init);

	void inject(BlogModule.EagerSingletons init);

	void inject(ConversationModule.EagerSingletons init);

	void inject(ForumModule.EagerSingletons init);

	void inject(GroupInvitationModule.EagerSingletons init);

	void inject(IdentityModule.EagerSingletons init);

	void inject(IntroductionModule.EagerSingletons init);

	void inject(MessagingModule.EagerSingletons init);

	void inject(PrivateGroupModule.EagerSingletons init);

	void inject(SharingModule.EagerSingletons init);

	LifecycleManager getLifecycleManager();

	AttachmentReader getAttachmentReader();

	AvatarManager getAvatarManager();

	ContactManager getContactManager();

	ConversationManager getConversationManager();

	DatabaseComponent getDatabaseComponent();

	BlogManager getBlogManager();

	BlogSharingManager getBlogSharingManager();

	ForumSharingManager getForumSharingManager();

	ForumManager getForumManager();

	GroupInvitationManager getGroupInvitationManager();

	GroupInvitationFactory getGroupInvitationFactory();

	IntroductionManager getIntroductionManager();

	MessageTracker getMessageTracker();

	MessagingManager getMessagingManager();

	PrivateGroupManager getPrivateGroupManager();

	PrivateMessageFactory getPrivateMessageFactory();

	TransportPropertyManager getTransportPropertyManager();

	AuthorFactory getAuthorFactory();

	BlogFactory getBlogFactory();

	AutoDeleteManager getAutoDeleteManager();

	Clock getClock();

	TimeTravel getTimeTravel();

	class Helper {

		public static void injectEagerSingletons(
				BriarIntegrationTestComponent c) {
			BrambleCoreIntegrationTestEagerSingletons.Helper
					.injectEagerSingletons(c);
			c.inject(new AutoDeleteModule.EagerSingletons());
			c.inject(new AvatarModule.EagerSingletons());
			c.inject(new BlogModule.EagerSingletons());
			c.inject(new ConversationModule.EagerSingletons());
			c.inject(new ForumModule.EagerSingletons());
			c.inject(new GroupInvitationModule.EagerSingletons());
			c.inject(new IdentityModule.EagerSingletons());
			c.inject(new IntroductionModule.EagerSingletons());
			c.inject(new MessagingModule.EagerSingletons());
			c.inject(new PrivateGroupModule.EagerSingletons());
			c.inject(new SharingModule.EagerSingletons());
		}
	}
}
