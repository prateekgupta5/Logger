package org.example;

import org.example.logger.ManualLogger;
import org.example.loggerAtrribute.AttrMedian;
import org.example.loggerBuilder.LoggerBuilder;
import org.example.loggerManager.LoggerManager;

import java.io.IOException;


import static org.example.util.DefaultFile.DEFAULT_FILE;

public class Main {
    static LoggerManager loggers;
    static ManualLogger<String> logger;

    public static void main(String[] args) throws IOException {
        loggers = new LoggerManager();

        logger = new ManualLogger<>(new LoggerBuilder(null, "test", null, null)
                .averageTimePerLog()
                .build()
        );

        System.out.println("logger = " + logger == null);

        loggers.add(logger);
        loggers.activateAll();

        System.out.println("louts for default file: " + loggers.louts.get(DEFAULT_FILE));
        logger.log("0");
        logger.log("1");

        loggers.storeLogs();
    }
}