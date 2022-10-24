package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Singleton
public class ConsoleAndFileLogger extends LoggerClass {
    private static Logger consoleLogger;

    @Override
    public void log(String message) {
        MDC.put("id", String.valueOf(logNumber++));
        consoleLogger.info(message);
        MDC.put("id", String.valueOf(logNumber++));
        logger.info(message);
    }

    @Inject
    public ConsoleAndFileLogger() {
        super();
        consoleLogger = LoggerFactory.getLogger("consoleLogger");
        logger = LoggerFactory.getLogger("fileLogger");
    }
}
