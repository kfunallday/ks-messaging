package com.ksmessaging.android;

import com.ksmessaging.BuildConfig;

import static java.util.concurrent.TimeUnit.DAYS;
import static com.ksmessaging.BuildConfig.BuildTimestamp;

public interface TestingConstants {

    /**
     * Whether this is a debug build.
     */
    boolean IS_DEBUG_BUILD = BuildConfig.DEBUG;

    /**
     * Whether to prevent screenshots from being taken. Setting this to true
     * prevents Recent Apps from storing screenshots of private information.
     * Unfortunately this also prevents the user from taking screenshots
     * intentionally.
     */
    boolean PREVENT_SCREENSHOTS = !IS_DEBUG_BUILD;

    /**
     * Set to Long.MAX_VALUE so the build never expires.
     */
    long EXPIRY_DATE = Long.MAX_VALUE;
}