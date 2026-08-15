package com.ksmessaging.android.privategroup.invitation;

import com.ksmessaging.android.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class GroupInvitationModule {

	@ActivityScope
	@Provides
	GroupInvitationController provideInvitationGroupController(
			GroupInvitationControllerImpl groupInvitationController) {
		return groupInvitationController;
	}
}
