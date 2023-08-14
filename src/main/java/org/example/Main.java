package org.example;

import org.example.logger.ManualLogger;
import org.example.loggerAtrribute.AttrMedian;
import org.example.loggerBuilder.LoggerBuilder;
import org.example.loggerManager.LoggerManager;
import org.example.loggerOut.FileSet;

import java.io.IOException;


import static org.example.util.DefaultFile.DEFAULT_FILE;

public class Main {
    static LoggerManager loggers;
    static ManualLogger<String> logger;
    static FileSet fileSet;

    public static void main(String[] args) throws IOException {
        fileSet = new FileSet("test");

        loggers = new LoggerManager();

        logger = new ManualLogger<>(new LoggerBuilder(null, "test", fileSet.getNewEntry().getAbsolutePath(), null)
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