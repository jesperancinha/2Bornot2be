package com.steelzack.b2b2java8.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

/**
 * Created by joaofilipesabinoesperancinha on 10-05-16.
 */
public class SystemOut {

    public ByteArrayOutputStream testSystemOut(){
        StringWriter stringWriter = new StringWriter();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        final PrintStream out = new PrintStream(ps);
        System.setOut(out);
        return baos;
    }
}
