package com.example.algebratemplate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import retrofit2.Retrofit;

import static junit.framework.TestCase.assertTrue;

public class ProductInstancesTest {
    private static Retrofit ourInstance;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetInstance() throws Exception {
        ourInstance = ProductInstances.getInstance();
        Retrofit result = ProductInstances.getInstance();
        Assert.assertEquals(ourInstance,result);
        assertTrue(ourInstance != null);
    }
}