package com.epam.testng;

import com.epam.practice.test.HelloWorld;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by KUMAR SAURAV on 7/23/2017.
 */
public class BasicHelloWorldTest {
    protected HelloWorld helloWorld;

    /**
     * method to initialize instance
     */
    @BeforeClass
    public void setHelloWorld() {
        helloWorld = new HelloWorld();
    }
    /**
     * below methods to test execute method of hello world class
     */
    @Test
    @Parameters({"basicExpeted"})
    public void testBasicExecute(String expected) {
        String result = helloWorld.basicExecute();
        Assert.assertEquals(result, expected);
    }
}
