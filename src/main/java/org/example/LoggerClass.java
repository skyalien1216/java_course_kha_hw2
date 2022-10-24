package org.example;

import org.slf4j.Logger;

public abstract class LoggerClass {
    protected static int logNumber;
    protected static Logger logger;

    public LoggerClass() {
        logNumber = 0;
    }

    public abstract void log(String message);
}
