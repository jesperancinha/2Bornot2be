package com.steelzack.b2b2java8;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jesperancinha on 9-5-16.
 */

public class CredentialsReaderTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void readAllCredentials() throws Exception {
        final CredentialsReader credentialsReader = new CredentialsReader();
        final InputStream fileInputStreamWithOneKeyStore = getClass().getResourceAsStream("/keyStore.p12");

        final List<Certificate> certificateList = credentialsReader.readAllCredentials(fileInputStreamWithOneKeyStore, "test".toCharArray());

        assertNotNull(certificateList);
        assertThat(certificateList.size(), equalTo(1));
    }

    @Test(expected = Exception.class)
    public void readAllCredentials_nullPassowrd() throws Exception {
        final InputStream fileInputStreamWithOneKeyStore = getClass().getResourceAsStream("/keyStore_nopass.pfx");
        final CredentialsReader credentialsReader = new CredentialsReader();
            credentialsReader.readAllCredentials(fileInputStreamWithOneKeyStore, null);
    }

}
