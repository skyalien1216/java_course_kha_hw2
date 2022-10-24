package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.slf4j.MDC;

import java.net.URL;

@Singleton
public final class GuiceModule extends AbstractModule {
    private final int choice;

    @Override
    protected void configure(){
       switch (choice) {
            case 1 -> bind(LoggerClass.class).to(ConsoleLogger.class);
            case 2 -> bind(LoggerClass.class).to(FileLogger.class);
            case 3 -> bind(LoggerClass.class).to(ConsoleAndFileLogger.class);
            default -> throw new RuntimeException("CONFIGURATION ERROR// no such logging type");
        }
    }

    public GuiceModule(int choice, String tag) {
        URL tmp = GuiceModule.class.getClassLoader().getResource("logs/logback.log");
        assert tmp != null;
        System.setProperty("LogPath", tmp.getPath());
        MDC.put("tag", tag);
        this.choice = choice;
    }
}
