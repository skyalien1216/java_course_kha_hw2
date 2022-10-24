package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(@NotNull String[] args) {
        //logs to the file in kha_hw2\build\resources\main\logs\logback.log
        // 1 - console, 2 - file, 3 - composite, second argument - tag
        final Injector injector = Guice.createInjector(new GuiceModule(Integer.parseInt(args[0]), args[1]));
        injector.getInstance(LogInputClass.class).waitForInput();
    }
}