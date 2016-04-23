package com.steelzack.tests.logs;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class LoggerInfoTest {
    private final OutputStream logCapturingStream = new ByteArrayOutputStream();
    private final StreamHandler customLogHandler;

    public LoggerInfoTest(Class... classes) {
        customLogHandler = new StreamHandler(logCapturingStream, Logger.getLogger(classes[0].getName()).getParent().getHandlers()[0].getFormatter());
        for (Class classje : classes) {
            Logger.getLogger(classje.getName()).addHandler(customLogHandler);
        }
    }

    protected String flushLogs() {
        customLogHandler.flush();
        return logCapturingStream.toString();
    }
}
