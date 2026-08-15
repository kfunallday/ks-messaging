package com.ksmessaging.android.attachment.media;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
		MediaModule.class
})
interface AbstractImageCompressorComponent {

	void inject(AbstractImageCompressorTest test);

}
