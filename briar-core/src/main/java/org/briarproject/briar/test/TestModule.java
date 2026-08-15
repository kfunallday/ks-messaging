package com.ksmessaging.test;

import com.ksmessaging.api.test.TestDataCreator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

	@Provides
	@Singleton
	TestDataCreator getTestDataCreator(TestDataCreatorImpl testDataCreator) {
		return testDataCreator;
	}

}
