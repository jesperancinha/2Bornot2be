package org.jesperancinha.b2b2java8.utils;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class EscapeSentenceTestTest {

    @Test
    public void escapedSentence() throws Exception {
        assertThat(EscapeSentenceTest.escapedSentence("João"), equalTo("Jo\\u00E3o"));
        assertThat(EscapeSentenceTest.escapedSentence("Zoë"), equalTo("Zo\\u00EB"));
    }

}
