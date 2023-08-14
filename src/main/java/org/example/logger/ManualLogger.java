package org.example.logger;

import org.example.loggerAtrribute.LoggerAttribute;

import java.util.ArrayList;

public class ManualLogger<T> extends AbstractLogger{
    public ManualLogger(String name, String file, String unit, ArrayList<LoggerAttribute> attributes) {
        super(null, name, file, unit, attributes);
    }

    public ManualLogger (AbstractLogger other) {
        super(other);
    }

    @Deprecated
    @Override
    public void tick(Object value) {
        ++currentTick;
    }

    @Override
    public void tick() {
        ++currentTick;
    }
}
