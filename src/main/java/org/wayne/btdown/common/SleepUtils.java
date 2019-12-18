package org.wayne.btdown.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger("");

    public static void sleep(long duration, boolean printLog) {

        if (printLog) {
            LOGGER.info("sleeping for {}...", duration);
        }

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sleep(long duration) {
        sleep(duration, true);
    }
}
