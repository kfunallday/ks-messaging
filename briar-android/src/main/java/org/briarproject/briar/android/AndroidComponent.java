package com.ksmessaging.android;

import org.briarproject.android.dontkillmelib.wakelock.AndroidWakeLockManager;
import org.briarproject.bramble.BrambleAndroidEagerSingletons;
import org.briarproject.bramble.BrambleAndroidModule;
import org.briarproject.bramble.BrambleAppComponent;
import org.briarproject.bramble.BrambleCoreEagerSingletons;
import org.briarproject.bramble.BrambleCoreModule;
import org.briarproject.bramble.account.BriarAccountModule;
import org.briarproject.bramble.api.FeatureFlags;
import org.briarproject.bramble.api.account.AccountManager;
import org.briarproject.bramble.api.connection.ConnectionRegistry;
import org.briarproject.bramble.api.contact.ContactExchangeManager;
import org.briarproject.bramble.api.contact.ContactManager;
import org.briarproject.bramble.api.crypto.CryptoExecutor;
import org.briarproject.bramble.api.crypto.PasswordStrengthEstimator;
import org.briarproject.bramble.api.db.DatabaseExecutor;
import org.briarproject.bramble.api.db.TransactionManager;
import org.briarproject.bramble.api.event.EventBus;
import org.briarproject.bramble.api.identity.IdentityManager;
import org.briarproject.bramble.api.keyagreement.KeyAgreementTask;
import org.briarproject.bramble.api.keyagreement.PayloadEncoder;
import org.briarproject.bramble.api.keyagreement.PayloadParser;
import org.briarproject.bramble.api.lifecycle.IoExecutor;
import org.briarproject.bramble.api.lifecycle.LifecycleManager;
import org.briarproject.bramble.api.plugin.PluginManager;
import org.briarproject.bramble.api.settings.SettingsManager;
import org.briarproject.bramble.api.system.AndroidExecutor;
import org.briarproject.bramble.api.system.Clock;
import org.briarproject.bramble.mailbox.ModularMailboxModule;
import org.briarproject.bramble.plugin.file.RemovableDriveModule;
import org.briarproject.bramble.system.ClockModule;
import com.ksmessaging.BriarCoreEagerSingletons;
import com.ksmessaging.BriarCoreModule;
import com.ksmessaging.android.attachment.AttachmentModule;
import com.ksmessaging.android.attachment.media.MediaModule;
import com.ksmessaging.android.contact.connect.BluetoothIntroFragment;
import com.ksmessaging.android.conversation.glide.BriarModelLoader;
import com.ksmessaging.android.hotspot.AbstractTabsFragment;
import com.ksmessaging.android.hotspot.FallbackFragment;
import com.ksmessaging.android.hotspot.HotspotIntroFragment;
import com.ksmessaging.android.hotspot.ManualHotspotFragment;
import com.ksmessaging.android.hotspot.QrHotspotFragment;
import com.ksmessaging.android.logging.CachingLogHandler;
import com.ksmessaging.android.login.SignInReminderReceiver;
import com.ksmessaging.android.mailbox.ErrorFragment;
import com.ksmessaging.android.mailbox.ErrorWizardFragment;
import com.ksmessaging.android.mailbox.MailboxScanFragment;
import com.ksmessaging.android.mailbox.MailboxStatusFragment;
import com.ksmessaging.android.mailbox.OfflineFragment;
import com.ksmessaging.android.mailbox.SetupDownloadFragment;
import com.ksmessaging.android.mailbox.SetupIntroFragment;
import com.ksmessaging.android.removabledrive.ChooserFragment;
import com.ksmessaging.android.removabledrive.ReceiveFragment;
import com.ksmessaging.android.removabledrive.SendFragment;
import com.ksmessaging.android.settings.ConnectionsFragment;
import com.ksmessaging.android.settings.NotificationsFragment;
import com.ksmessaging.android.settings.SecurityFragment;
import com.ksmessaging.android.settings.SettingsFragment;
import com.ksmessaging.android.view.EmojiTextInputView;
import com.ksmessaging.api.android.AndroidNotificationManager;
import com.ksmessaging.api.android.DozeWatchdog;
import com.ksmessaging.api.android.LockManager;
import com.ksmessaging.api.android.ScreenFilterMonitor;
import com.ksmessaging.api.attachment.AttachmentReader;
import com.ksmessaging.api.autodelete.AutoDeleteManager;
import com.ksmessaging.api.blog.BlogManager;
import com.ksmessaging.api.blog.BlogPostFactory;
import com.ksmessaging.api.blog.BlogSharingManager;
import com.ksmessaging.api.client.MessageTracker;
import com.ksmessaging.api.conversation.ConversationManager;
import com.ksmessaging.api.feed.FeedManager;
import com.ksmessaging.api.forum.ForumManager;
import com.ksmessaging.api.forum.ForumSharingManager;
import com.ksmessaging.api.identity.AuthorManager;
import com.ksmessaging.api.introduction.IntroductionManager;
import com.ksmessaging.api.messaging.MessagingManager;
import com.ksmessaging.api.messaging.PrivateMessageFactory;
import com.ksmessaging.api.privategroup.GroupMessageFactory;
import com.ksmessaging.api.privategroup.PrivateGroupFactory;
import com.ksmessaging.api.privategroup.PrivateGroupManager;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationFactory;
import com.ksmessaging.api.privategroup.invitation.GroupInvitationManager;
import com.ksmessaging.api.test.TestDataCreator;
import org.briarproject.onionwrapper.CircumventionProvider;
import org.briarproject.onionwrapper.LocationUtils;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Component;

@Singleton
@Component(modules = {
		BrambleCoreModule.class,
		BriarCoreModule.class,
		BrambleAndroidModule.class,
		BriarAccountModule.class,
		AppModule.class,
		AttachmentModule.class,
		ClockModule.class,
		MediaModule.class,
		ModularMailboxModule.class,
		RemovableDriveModule.class
})
public interface AndroidComponent
		extends BrambleCoreEagerSingletons, BrambleAndroidEagerSingletons,
		BriarCoreEagerSingletons, AndroidEagerSingletons, BrambleAppComponent {

	// Exposed objects
	@CryptoExecutor
	Executor cryptoExecutor();

	PasswordStrengthEstimator passwordStrengthIndicator();

	@DatabaseExecutor
	Executor databaseExecutor();

	TransactionManager transactionManager();

	MessageTracker messageTracker();

	LifecycleManager lifecycleManager();

	IdentityManager identityManager();

	AttachmentReader attachmentReader();

	AuthorManager authorManager();

	PluginManager pluginManager();

	EventBus eventBus();

	AndroidNotificationManager androidNotificationManager();

	ScreenFilterMonitor screenFilterMonitor();

	ConnectionRegistry connectionRegistry();

	ContactManager contactManager();

	ConversationManager conversationManager();

	MessagingManager messagingManager();

	PrivateMessageFactory privateMessageFactory();

	PrivateGroupManager privateGroupManager();

	GroupInvitationFactory groupInvitationFactory();

	GroupInvitationManager groupInvitationManager();

	PrivateGroupFactory privateGroupFactory();

	GroupMessageFactory groupMessageFactory();

	ForumManager forumManager();

	ForumSharingManager forumSharingManager();

	BlogSharingManager blogSharingManager();

	BlogManager blogManager();

	BlogPostFactory blogPostFactory();

	SettingsManager settingsManager();

	ContactExchangeManager contactExchangeManager();

	KeyAgreementTask keyAgreementTask();

	PayloadEncoder payloadEncoder();

	PayloadParser payloadParser();

	IntroductionManager introductionManager();

	AndroidExecutor androidExecutor();

	FeedManager feedManager();

	Clock clock();

	TestDataCreator testDataCreator();

	DozeWatchdog dozeWatchdog();

	@IoExecutor
	Executor ioExecutor();

	AccountManager accountManager();

	LockManager lockManager();

	LocationUtils locationUtils();

	CircumventionProvider circumventionProvider();

	ViewModelProvider.Factory viewModelFactory();

	FeatureFlags featureFlags();

	AndroidWakeLockManager wakeLockManager();

	CachingLogHandler logHandler();

	Thread.UncaughtExceptionHandler exceptionHandler();

	AutoDeleteManager autoDeleteManager();

	void inject(SignInReminderReceiver briarService);

	void inject(BriarService briarService);

	void inject(NotificationCleanupService notificationCleanupService);

	void inject(EmojiTextInputView textInputView);

	void inject(BriarModelLoader briarModelLoader);

	void inject(SettingsFragment settingsFragment);

	void inject(ConnectionsFragment connectionsFragment);

	void inject(SecurityFragment securityFragment);

	void inject(NotificationsFragment notificationsFragment);

	void inject(HotspotIntroFragment hotspotIntroFragment);

	void inject(AbstractTabsFragment abstractTabsFragment);

	void inject(QrHotspotFragment qrHotspotFragment);

	void inject(ManualHotspotFragment manualHotspotFragment);

	void inject(FallbackFragment fallbackFragment);

	void inject(ChooserFragment chooserFragment);

	void inject(SendFragment sendFragment);

	void inject(ReceiveFragment receiveFragment);

	void inject(BluetoothIntroFragment bluetoothIntroFragment);

	void inject(SetupIntroFragment setupIntroFragment);

	void inject(SetupDownloadFragment setupDownloadFragment);

	void inject(MailboxScanFragment mailboxScanFragment);

	void inject(OfflineFragment offlineFragment);

	void inject(ErrorFragment errorFragment);

	void inject(MailboxStatusFragment mailboxStatusFragment);

	void inject(ErrorWizardFragment errorWizardFragment);
}
