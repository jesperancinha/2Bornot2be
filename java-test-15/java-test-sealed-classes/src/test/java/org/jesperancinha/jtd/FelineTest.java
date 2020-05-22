package org.jesperancinha.jtd;

import org.jesperancinha.jtd.cats.Lion;
import org.jesperancinha.jtd.cats.Panther;
import org.jesperancinha.jtd.cats.Tigre;
import org.jesperancinha.jtd.cats.Whale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FelineTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testFeline() {
        new Lion();
        new Panther();
        new Tigre();
        new Whale();
    }

}