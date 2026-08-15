package com.ksmessaging.android.activity;

import android.app.Activity;

import com.ksmessaging.android.AndroidComponent;
import com.ksmessaging.android.StartupFailureActivity;
import com.ksmessaging.android.account.SetupActivity;
import com.ksmessaging.android.account.SetupFragment;
import com.ksmessaging.android.account.UnlockActivity;
import com.ksmessaging.android.blog.BlogActivity;
import com.ksmessaging.android.blog.BlogFragment;
import com.ksmessaging.android.blog.BlogPostFragment;
import com.ksmessaging.android.blog.FeedFragment;
import com.ksmessaging.android.blog.ReblogActivity;
import com.ksmessaging.android.blog.ReblogFragment;
import com.ksmessaging.android.blog.RssFeedActivity;
import com.ksmessaging.android.blog.RssFeedDeleteFeedDialogFragment;
import com.ksmessaging.android.blog.RssFeedImportFailedDialogFragment;
import com.ksmessaging.android.blog.RssFeedImportFragment;
import com.ksmessaging.android.blog.RssFeedManageFragment;
import com.ksmessaging.android.blog.WriteBlogPostActivity;
import com.ksmessaging.android.contact.ContactListFragment;
import com.ksmessaging.android.contact.add.nearby.AddNearbyContactActivity;
import com.ksmessaging.android.contact.add.nearby.AddNearbyContactErrorFragment;
import com.ksmessaging.android.contact.add.nearby.AddNearbyContactFragment;
import com.ksmessaging.android.contact.add.nearby.AddNearbyContactIntroFragment;
import com.ksmessaging.android.contact.add.remote.AddContactActivity;
import com.ksmessaging.android.contact.add.remote.LinkExchangeFragment;
import com.ksmessaging.android.contact.add.remote.NicknameFragment;
import com.ksmessaging.android.contact.add.remote.PendingContactListActivity;
import com.ksmessaging.android.contact.connect.ConnectViaBluetoothActivity;
import com.ksmessaging.android.conversation.AliasDialogFragment;
import com.ksmessaging.android.conversation.ConversationActivity;
import com.ksmessaging.android.conversation.ConversationSettingsDialog;
import com.ksmessaging.android.conversation.ImageActivity;
import com.ksmessaging.android.conversation.ImageFragment;
import com.ksmessaging.android.forum.CreateForumActivity;
import com.ksmessaging.android.forum.ForumActivity;
import com.ksmessaging.android.forum.ForumListFragment;
import com.ksmessaging.android.fragment.ScreenFilterDialogFragment;
import com.ksmessaging.android.hotspot.HotspotActivity;
import com.ksmessaging.android.introduction.ContactChooserFragment;
import com.ksmessaging.android.introduction.IntroductionActivity;
import com.ksmessaging.android.introduction.IntroductionMessageFragment;
import com.ksmessaging.android.login.ChangePasswordActivity;
import com.ksmessaging.android.login.OpenDatabaseFragment;
import com.ksmessaging.android.login.PasswordFragment;
import com.ksmessaging.android.login.StartupActivity;
import com.ksmessaging.android.mailbox.MailboxActivity;
import com.ksmessaging.android.navdrawer.NavDrawerActivity;
import com.ksmessaging.android.navdrawer.TransportsActivity;
import com.ksmessaging.android.panic.PanicPreferencesActivity;
import com.ksmessaging.android.panic.PanicResponderActivity;
import com.ksmessaging.android.privategroup.conversation.GroupActivity;
import com.ksmessaging.android.privategroup.creation.CreateGroupActivity;
import com.ksmessaging.android.privategroup.creation.CreateGroupFragment;
import com.ksmessaging.android.privategroup.creation.CreateGroupModule;
import com.ksmessaging.android.privategroup.creation.GroupInviteActivity;
import com.ksmessaging.android.privategroup.creation.GroupInviteFragment;
import com.ksmessaging.android.privategroup.invitation.GroupInvitationActivity;
import com.ksmessaging.android.privategroup.invitation.GroupInvitationModule;
import com.ksmessaging.android.privategroup.list.GroupListFragment;
import com.ksmessaging.android.privategroup.memberlist.GroupMemberListActivity;
import com.ksmessaging.android.privategroup.memberlist.GroupMemberModule;
import com.ksmessaging.android.privategroup.reveal.GroupRevealModule;
import com.ksmessaging.android.privategroup.reveal.RevealContactsActivity;
import com.ksmessaging.android.privategroup.reveal.RevealContactsFragment;
import com.ksmessaging.android.removabledrive.RemovableDriveActivity;
import com.ksmessaging.android.reporting.CrashFragment;
import com.ksmessaging.android.reporting.CrashReportActivity;
import com.ksmessaging.android.reporting.ReportFormFragment;
import com.ksmessaging.android.settings.ConfirmAvatarDialogFragment;
import com.ksmessaging.android.settings.SettingsActivity;
import com.ksmessaging.android.settings.SettingsFragment;
import com.ksmessaging.android.sharing.BlogInvitationActivity;
import com.ksmessaging.android.sharing.BlogSharingStatusActivity;
import com.ksmessaging.android.sharing.ForumInvitationActivity;
import com.ksmessaging.android.sharing.ForumSharingStatusActivity;
import com.ksmessaging.android.sharing.ShareBlogActivity;
import com.ksmessaging.android.sharing.ShareBlogFragment;
import com.ksmessaging.android.sharing.ShareForumActivity;
import com.ksmessaging.android.sharing.ShareForumFragment;
import com.ksmessaging.android.sharing.SharingModule;
import com.ksmessaging.android.splash.SplashScreenActivity;
import com.ksmessaging.android.test.TestDataActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {
		ActivityModule.class,
		CreateGroupModule.class,
		GroupInvitationModule.class,
		GroupMemberModule.class,
		GroupRevealModule.class,
		SharingModule.SharingLegacyModule.class
}, dependencies = AndroidComponent.class)
public interface ActivityComponent {

	Activity activity();

	void inject(SplashScreenActivity activity);

	void inject(StartupActivity activity);

	void inject(SetupActivity activity);

	void inject(NavDrawerActivity activity);

	void inject(PanicResponderActivity activity);

	void inject(PanicPreferencesActivity activity);

	void inject(AddNearbyContactActivity activity);

	void inject(ConversationActivity activity);

	void inject(ImageActivity activity);

	void inject(ForumInvitationActivity activity);

	void inject(BlogInvitationActivity activity);

	void inject(CreateGroupActivity activity);

	void inject(GroupActivity activity);

	void inject(GroupInviteActivity activity);

	void inject(GroupInvitationActivity activity);

	void inject(GroupMemberListActivity activity);

	void inject(RevealContactsActivity activity);

	void inject(CreateForumActivity activity);

	void inject(ShareForumActivity activity);

	void inject(ShareBlogActivity activity);

	void inject(ForumSharingStatusActivity activity);

	void inject(BlogSharingStatusActivity activity);

	void inject(ForumActivity activity);

	void inject(BlogActivity activity);

	void inject(WriteBlogPostActivity activity);

	void inject(BlogFragment fragment);

	void inject(BlogPostFragment fragment);

	void inject(ReblogFragment fragment);

	void inject(ReblogActivity activity);

	void inject(SettingsActivity activity);

	void inject(TransportsActivity activity);

	void inject(TestDataActivity activity);

	void inject(ChangePasswordActivity activity);

	void inject(IntroductionActivity activity);

	void inject(RssFeedActivity activity);

	void inject(StartupFailureActivity activity);

	void inject(UnlockActivity activity);

	void inject(AddContactActivity activity);

	void inject(PendingContactListActivity activity);

	void inject(CrashReportActivity crashReportActivity);

	void inject(HotspotActivity hotspotActivity);

	void inject(RemovableDriveActivity activity);

	// Fragments

	void inject(SetupFragment fragment);

	void inject(PasswordFragment imageFragment);

	void inject(OpenDatabaseFragment activity);

	void inject(ContactListFragment fragment);

	void inject(CreateGroupFragment fragment);

	void inject(GroupListFragment fragment);

	void inject(GroupInviteFragment fragment);

	void inject(RevealContactsFragment activity);

	void inject(ForumListFragment fragment);

	void inject(FeedFragment fragment);

	void inject(AddNearbyContactIntroFragment fragment);

	void inject(AddNearbyContactFragment fragment);

	void inject(LinkExchangeFragment fragment);

	void inject(NicknameFragment fragment);

	void inject(ContactChooserFragment fragment);

	void inject(ShareForumFragment fragment);

	void inject(ShareBlogFragment fragment);

	void inject(IntroductionMessageFragment fragment);

	void inject(SettingsFragment fragment);

	void inject(ScreenFilterDialogFragment fragment);

	void inject(AddNearbyContactErrorFragment fragment);

	void inject(AliasDialogFragment aliasDialogFragment);

	void inject(ImageFragment imageFragment);

	void inject(ReportFormFragment reportFormFragment);

	void inject(CrashFragment crashFragment);

	void inject(ConfirmAvatarDialogFragment fragment);

	void inject(ConversationSettingsDialog dialog);

	void inject(RssFeedImportFragment fragment);

	void inject(RssFeedManageFragment fragment);

	void inject(RssFeedImportFailedDialogFragment fragment);

	void inject(RssFeedDeleteFeedDialogFragment fragment);

	void inject(ConnectViaBluetoothActivity connectViaBluetoothActivity);

	void inject(MailboxActivity mailboxActivity);
}
