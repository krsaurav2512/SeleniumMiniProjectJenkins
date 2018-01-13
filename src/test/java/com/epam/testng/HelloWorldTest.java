package com.epam.testng;

import com.epam.practice.test.HelloWorld;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * created to show functionality of test NG
 */
public class HelloWorldTest extends BasicHelloWorldTest {

    /**
     * below methods to test execute method of hello world class with different priority
     */
    @Test
    @Parameters({"expected"})
    public void testExecute(String expected) {
        String result = helloWorld.execute();
        Assert.assertEquals(result, expected);
    }

    @Test(priority = 1)
    @Parameters({"expected"})
    public void testExecuteWithParam(String expected) {
        String result = helloWorld.execute();
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testWithError() {
        int i = 1 / 0;
    }
}
