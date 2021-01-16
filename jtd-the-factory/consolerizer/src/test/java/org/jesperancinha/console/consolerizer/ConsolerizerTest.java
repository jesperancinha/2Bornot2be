package org.jesperancinha.console.consolerizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsolerizerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testPrintRainbowFlag_whenText_thenTextInMiddle() {
        Consolerizer.printRainbowFlag("Happy PRIDE Everyone!");
    }

    @AfterEach
    void tearDown() {
    }
}