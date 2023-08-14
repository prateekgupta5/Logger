package org.example.logger;

import org.example.loggerAtrribute.LoggerAttribute;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ChangeLogger<T> extends AbstractLogger{
    public ChangeLogger(Supplier src, String name, String file, String unit, ArrayList<LoggerAttribute> attributes) {
        super(src, name, file, unit, attributes);
    }

    public ChangeLogger (AbstractLogger other) {
        super(other);
    }

    @Deprecated
    @Override
    public void tick(Object value) {
        if(!value.equals(prevState)) {
            prevState = value;
            log(value);
        }
        ++currentTick;
    }

    @Override
    public void tick() {
        T value = (T) src.get();
        if(!src.get().equals(prevState)) {
            prevState = value;
            log(value);
        }
    }

    Object prevState;
}
