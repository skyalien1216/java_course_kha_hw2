package org.example;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Singleton
public class LogInputClass {

    private final LoggerClass logger;

    @Inject
    public LogInputClass(LoggerClass logger) {
        this.logger = logger;
    }

    public void waitForInput()
    {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                logger.log(scanner.nextLine());
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
