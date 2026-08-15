package com.ksmessaging.android.privategroup.memberlist;

import com.ksmessaging.android.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class GroupMemberModule {

	@ActivityScope
	@Provides
	GroupMemberListController provideGroupMemberListController(
			GroupMemberListControllerImpl groupMemberListController) {
		return groupMemberListController;
	}
}
