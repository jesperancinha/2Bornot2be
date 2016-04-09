package com.steelzack.b2b2java8;

import org.apache.commons.codec.DecoderException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class HashingManager {
    public String getHashedString(String stringToHash) throws NoSuchAlgorithmException, UnsupportedEncodingException, DecoderException {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(stringToHash.getBytes());
        final StringBuffer sb = new StringBuffer();
        byte[] digest = messageDigest.digest();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();

    }
}
