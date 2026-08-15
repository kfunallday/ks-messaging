package com.ksmessaging.android.sharing;

import com.ksmessaging.android.activity.ActivityScope;
import com.ksmessaging.android.activity.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class SharingModule {

	@Module
	@Deprecated
	public static class SharingLegacyModule {

		@ActivityScope
		@Provides
		ShareForumController provideShareForumController(
				ShareForumControllerImpl shareForumController) {
			return shareForumController;
		}

		@ActivityScope
		@Provides
		BlogInvitationController provideInvitationBlogController(
				BaseActivity activity,
				BlogInvitationControllerImpl blogInvitationController) {
			activity.addLifecycleController(blogInvitationController);
			return blogInvitationController;
		}

		@ActivityScope
		@Provides
		ForumInvitationController provideInvitationForumController(
				BaseActivity activity,
				ForumInvitationControllerImpl forumInvitationController) {
			activity.addLifecycleController(forumInvitationController);
			return forumInvitationController;
		}

		@ActivityScope
		@Provides
		ShareBlogController provideShareBlogController(
				ShareBlogControllerImpl shareBlogController) {
			return shareBlogController;
		}
	}

	@Provides
	SharingController provideSharingController(
			SharingControllerImpl sharingController) {
		return sharingController;
	}

}
