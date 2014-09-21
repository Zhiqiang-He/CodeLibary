package com.james.codelib.guava.patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 9/21/14.
 */
public class LogTest {
    public static final Logger LOG = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            LOG.info("log test!");
        }
    }
}
