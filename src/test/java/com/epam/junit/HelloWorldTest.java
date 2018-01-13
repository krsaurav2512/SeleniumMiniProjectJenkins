package com.epam.junit;


import com.epam.practice.test.HelloWorld;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * created to show functionality of junit
 */
public class HelloWorldTest {

    private HelloWorld helloWorld;

    /**
     * method to initialize instance
     */
    @Before
    public void setHelloWorld() {
        helloWorld = new HelloWorld();
    }

    /**
     * method to test execute method of hello world class
     */
    @Test
    public void testExecute() {
        String actualResult = helloWorld.execute();
        Assert.assertEquals("Hello World!", actualResult);
    }
}
