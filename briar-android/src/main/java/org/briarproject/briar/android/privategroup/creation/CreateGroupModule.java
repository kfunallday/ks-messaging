package com.ksmessaging.android.privategroup.creation;

import com.ksmessaging.android.activity.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateGroupModule {

	@ActivityScope
	@Provides
	CreateGroupController provideCreateGroupController(
			CreateGroupControllerImpl createGroupController) {
		return createGroupController;
	}

}
