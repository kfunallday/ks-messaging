package com.ksmessaging.api.introduction;

import static org.briarproject.bramble.api.sync.SyncConstants.MAX_MESSAGE_BODY_LENGTH;

public interface IntroductionConstants {

	/**
	 * The maximum length of the introducer's optional message to the
	 * introducees in UTF-8 bytes.
	 */
	int MAX_INTRODUCTION_TEXT_LENGTH = MAX_MESSAGE_BODY_LENGTH - 1024;

	String LABEL_SESSION_ID = "com.ksmessaging.introduction/SESSION_ID";

	String LABEL_MASTER_KEY = "com.ksmessaging.introduction/MASTER_KEY";

	String LABEL_ALICE_MAC_KEY =
			"com.ksmessaging.introduction/ALICE_MAC_KEY";

	String LABEL_BOB_MAC_KEY =
			"com.ksmessaging.introduction/BOB_MAC_KEY";

	String LABEL_AUTH_MAC = "com.ksmessaging.introduction/AUTH_MAC";

	String LABEL_AUTH_SIGN = "com.ksmessaging.introduction/AUTH_SIGN";

	String LABEL_AUTH_NONCE = "com.ksmessaging.introduction/AUTH_NONCE";

	String LABEL_ACTIVATE_MAC =
			"com.ksmessaging.introduction/ACTIVATE_MAC";

}
