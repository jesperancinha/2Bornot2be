package com.steelzack.b2b2java8.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class DateToMicrosecondsFormat {

    private static final DateTimeFormatter FROM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH+mm+ss+SSSSSS");
    private static final DateTimeFormatter TO_FORMATTER = DateTimeFormatter.ofPattern("SSSSSS");

    private static final SimpleDateFormat FROM_SIMPLE = new SimpleDateFormat("yyyy-MM-dd-HH+mm+ss+SSSSSS");
    private static final SimpleDateFormat TO_SIMPLE = new SimpleDateFormat("SSSSSS");

    public static String fromDateToDate(String srcDate) {
        return TO_FORMATTER.format(FROM_FORMATTER.parse(srcDate));
    }

    public static String fromDateToDateSimple(String srcDate) throws ParseException {
        return TO_SIMPLE.format(FROM_SIMPLE.parse(srcDate));
    }
}
