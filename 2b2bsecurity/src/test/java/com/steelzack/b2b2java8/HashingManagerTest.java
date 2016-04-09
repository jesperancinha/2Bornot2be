package com.steelzack.b2b2java8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class HashingManagerTest {
    @Test
    public void getHashStringSHA1() throws Exception {
        final HashingManager hashingManager = new HashingManager();
        final String hashedString = hashingManager.getHashStringSHA1("The quick brown fox jumps over the lazy dog");
        assertEquals("2fd4e1c67a2d28fced849ee1bb76e7391b93eb12", hashedString);
    }

    @Test
    public void getHashedStringMD5() throws Exception {
        final HashingManager hashingManager = new HashingManager();

        final String hashedString = hashingManager.getHashedStringMD5("The quick brown fox jumps over the lazy dog");
        assertEquals("9e107d9d372bb6826bd81d3542a419d6", hashedString);
    }
}