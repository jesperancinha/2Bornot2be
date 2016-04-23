package com.steelzack.b2b2designpatterns.chainofresponsibility;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class LoggerInfoTest {
    private final Logger log1 = Logger.getLogger(Arado.class.getName());
    private final OutputStream logCapturingStream = new ByteArrayOutputStream();
    private final StreamHandler customLogHandler = new StreamHandler(logCapturingStream, log1.getParent().getHandlers()[0].getFormatter());

    LoggerInfoTest() {
        log1.addHandler(customLogHandler);
        Logger.getLogger(Bell.class.getName()).addHandler(customLogHandler);
        Logger.getLogger(Caproni.class.getName()).addHandler(customLogHandler);
    }

    String flushLogs() {
        customLogHandler.flush();
        return logCapturingStream.toString();
    }
}
