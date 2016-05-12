package com.steelzack.b2b2java8.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class DateToMicrosecondsFormatTest {

    @Test
    public void fromDateToDateSimple() throws Exception {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = DateToMicrosecondsFormat.fromDateToDateSimple(inputDate);

        assertThat(result, equalTo("000456"));
    }

    @Test
    public void fromDateToDate() throws Exception {
        final String inputDate = "2016-05-12-21+42+21+123456";

        final String result = DateToMicrosecondsFormat.fromDateToDate(inputDate);

        assertThat(result, equalTo("123456"));
    }

}
