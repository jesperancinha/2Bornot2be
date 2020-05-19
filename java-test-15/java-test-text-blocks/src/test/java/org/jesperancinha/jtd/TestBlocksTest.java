package org.jesperancinha.jtd;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBlocksTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLineTerminator_whenMultipleLines_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test1.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                        Cat Two
                        Cat Three
                        """);
    }

    @Test
    void testLineTerminator_whenMultipleLinesNoLastNewLine_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test2.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                        Cat Two
                        Cat Three""");
    }

    @Test
    void testLineTerminator_whenIdentation_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test3.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                          Cat Two
                        Cat Three
                        """);
    }

    @Test
    void testLineTerminator_whenIdentationFromEnd_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test4.txt"));

        assertThat(text).isEqualTo(
                """
                          Cat One
                          Cat Two
                          Cat Three
                        """);
    }

    @Test
    void testLineTerminator_whenIdentationFromStart_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test1.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                        Cat Two
                        Cat Three
                        """);
    }

    @Test
    void testLineTerminator_whenIdentationMixed_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test5.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                          Cat Two
                        Cat Three
                          Cat Four""");
    }

    @Test
    void testLineTerminator_whenQuotes_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test6.txt"));

        assertThat(text).isEqualTo(
                """
                        "Cat" One
                        Cat "Two"
                        "Cat" Three
                        "Cat Four\"""");
    }

    @Test
    void testLineTerminator_when3Quotes_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test7.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One
                        \"""Cat Two\"""
                        Cat Three
                        """);
    }

    @Test
    void testLineTerminator_whenEscapeCharacters_thenOk() throws IOException {

        assertThat("Cat One\nCat Four\n" +
                "Cat Two\u0009Cat Five\n" +
                "Cat Three" + (char) 0x0D + " Cat Six\n" +
                "Cat Seven\'Cat Eight\\" +
                "\n"
        ).isEqualTo(
                """
                        Cat One\nCat Four
                        Cat Two\tCat Five
                        Cat Three\r Cat Six
                        Cat Seven\'Cat Eight\\
                        """);
    }

    @Test
    void testLineTerminator_whenSpaceTermination_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test9.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One \
                        Cat Two \
                        Cat Three\
                        """);
    }

    @Test
    void testLineTerminator_whenSpaceTerminationEscaped_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test10.txt"));

        assertThat(text).isEqualTo(
                """
                        Cat One \
                        Cat Two \
                        Cat Three\
                        """);
    }

    @Test
    void testLineTerminator_whenStringReplacement_thenOk() throws IOException {
        final String text = IOUtils.toString(getClass().getResourceAsStream("/test11.txt"));

        assertThat(text).isEqualTo(String.format(
                """
                        Cat One's name is %s
                        Cat Two's name is %s
                        Cat Three's name is %s
                        """, "Zuu", "Brinca", "Tommy"));

    }
}