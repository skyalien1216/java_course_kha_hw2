package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Singleton
public class ConsoleLogger extends LoggerClass {
    @Override
    public void log(String message) {
        MDC.put("id", String.valueOf(logNumber++));
        logger.info(message);
    }

    @Inject
    public ConsoleLogger() {
        super();
        logger  = LoggerFactory.getLogger("consoleLogger");
    }
}
