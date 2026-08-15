package com.ksmessaging.android.conversation;

import com.ksmessaging.android.activity.ActivityScope;
import com.ksmessaging.android.conversation.glide.BriarDataFetcherFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConversationModule {

	@ActivityScope
	@Provides
	BriarDataFetcherFactory provideBriarDataFetcherFactory(
			BriarDataFetcherFactory dataFetcherFactory) {
		return dataFetcherFactory;
	}

}
