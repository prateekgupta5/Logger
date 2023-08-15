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
    static ManualLogger<String> logger1;
    static ManualLogger<String> logger2;

    static ManualLogger<String> loggerDefault;

    static FileSet fileSet;

    public static void main(String[] args) throws IOException {
        fileSet = new FileSet("test");

        loggers = new LoggerManager();

        String filepath = fileSet.getNewEntry().getAbsolutePath();

        logger1 = new ManualLogger<>(new LoggerBuilder(null, "test1", filepath, null)
                .averageTimePerLog()
                .build()
        );

        logger2 = new ManualLogger<>(new LoggerBuilder(null, "test2", filepath, null)
                .averageTimePerLog()
                .build()
        );

        loggerDefault = new ManualLogger<>(new LoggerBuilder(null, "testDefault", null, null)
                .averageTimePerLog()
                .build()
        );

        loggers.add(logger1);
        loggers.add(logger2);
        loggers.add(loggerDefault);
        loggers.activateAll();

        System.out.println("louts for default file: " + loggers.louts.get(DEFAULT_FILE));
        logger1.log("0");
        logger1.log("1");

        loggers.storeLogs();
    }
}