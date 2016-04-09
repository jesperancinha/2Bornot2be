package com.steelzack.b2b2java8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class HashingManagerTest {
    @Test
    public void getHashedString() throws Exception {
        final HashingManager hashingManager = new HashingManager();

        final String hashedString = hashingManager.getHashedString("The quick brown fox jumps over the lazy dog");
        assertEquals("9e107d9d372bb6826bd81d3542a419d6", hashedString);
    }
}