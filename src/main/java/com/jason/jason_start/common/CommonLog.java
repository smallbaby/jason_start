package com.jason.jason_start.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Jason
 * Date 2020/5/10
 */
public class CommonLog {
    private static final Logger log = LoggerFactory.getLogger(CommonLog.class);

    public static void info(String msg) {
        log.info(msg);
    }

    public static void info(String msg, String... params) {
        log.info(msg, params);
    }

    public static void error(String msg, Exception e) {
        log.error(msg, e);
    }
}
