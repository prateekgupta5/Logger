package org.example.logger;

import org.example.loggerAtrribute.LoggerAttribute;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ConstantLogger extends AbstractLogger{

    public ConstantLogger(Supplier src, String name, String file, String unit, ArrayList<LoggerAttribute> attributes) {
        super(src, name, file, unit, attributes);
    }

    public ConstantLogger (AbstractLogger other) {
        super(other);
    }

    @Deprecated
    @Override
    public void tick(Object value) {
        log(value);
        ++currentTick;
    }

    @Override
    public void tick() {
        log(src.get());
        ++currentTick;
    }
}
