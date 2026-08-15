package com.ksmessaging.introduction;

import org.briarproject.bramble.BrambleCoreModule;
import org.briarproject.bramble.mailbox.ModularMailboxModule;
import org.briarproject.bramble.test.BrambleCoreIntegrationTestModule;
import org.briarproject.bramble.test.TestDnsModule;
import org.briarproject.bramble.test.TestPluginConfigModule;
import org.briarproject.bramble.test.TestSocksModule;
import com.ksmessaging.attachment.AttachmentModule;
import com.ksmessaging.autodelete.AutoDeleteModule;
import com.ksmessaging.avatar.AvatarModule;
import com.ksmessaging.blog.BlogModule;
import com.ksmessaging.client.BriarClientModule;
import com.ksmessaging.conversation.ConversationModule;
import com.ksmessaging.forum.ForumModule;
import com.ksmessaging.identity.IdentityModule;
import com.ksmessaging.messaging.MessagingModule;
import com.ksmessaging.privategroup.PrivateGroupModule;
import com.ksmessaging.privategroup.invitation.GroupInvitationModule;
import com.ksmessaging.sharing.SharingModule;
import com.ksmessaging.test.BriarIntegrationTestComponent;

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
interface IntroductionIntegrationTestComponent
		extends BriarIntegrationTestComponent {

	void inject(IntroductionIntegrationTest init);

	void inject(MessageEncoderParserIntegrationTest init);

	void inject(SessionEncoderParserIntegrationTest init);

	void inject(IntroductionCryptoIntegrationTest init);

	void inject(AutoDeleteIntegrationTest init);

	MessageEncoder getMessageEncoder();

	MessageParser getMessageParser();

	SessionParser getSessionParser();

	IntroductionCrypto getIntroductionCrypto();

}
