package com.epam.calculator;

import static org.testng.Assert.assertEquals;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

/**
 * class is to test basic functionality of calculator.
 */
public class CalculatorTest {
    private static Logger logger = LogManager.getLogger();
    private Calculator calculator;
    ExtentReports extent;
    ExtentTest loggerExtent;

    /**
     * create instance of calculator class
     *
     * @throws Exception
     */
    @BeforeClass
    public void setUp() throws Exception {
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
        extent.addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Kumar Saurav");
        calculator = new Calculator();
    }

    /**
     * test addition method of calculator
     *
     * @param input1   - First input
     * @param input2   - Second input
     * @param expected - Expected value after addition
     */
    @Test(dataProviderClass = DataForCalculation.class, dataProvider = "addInput")
    public void testAddition(long input1, long input2, long expected) {
        long result = calculator.sum(input1, input2);
        assertEquals(expected, result);
        loggerExtent = extent.startTest("testAddition");
        loggerExtent.log(LogStatus.PASS, "Test Case Passed is passTest");

    }

    /**
     * test substraction method of calculator
     *
     * @param input1   - First input
     * @param input2   - Second input
     * @param expected - Expected value after substraction
     */
    @Test(dataProviderClass = DataForCalculation.class, dataProvider = "subInput")
    public void testSubstraction(long input1, long input2, long expected) {
        long result = calculator.sub(input1, input2);
        assertEquals(expected, result);
        loggerExtent = extent.startTest("testSubstraction");
        loggerExtent.log(LogStatus.PASS, "Test Case Passed is passTest");
    }

    /**
     * test multiplication method of calculator
     *
     * @param input1   - First input
     * @param input2   - Second input
     * @param expected - Expected value after multiplication
     */
    @Test(dataProviderClass = DataForCalculation.class, dataProvider = "mulInput")
    public void testMultiplication(long input1, long input2, long expected) {
        long result = calculator.mult(input1, input2);
        assertEquals(expected, result);
        loggerExtent = extent.startTest("testMultiplication");
        loggerExtent.log(LogStatus.PASS, "Test Case Passed is passTest");
    }

    /**
     * test division method of calculator
     *
     * @param input1   - First input
     * @param input2   - Second input
     * @param expected - Expected value after division
     * @throws ArithmeticException - if input2 is zero
     */
    @Test(dataProviderClass = DataForCalculation.class, dataProvider = "divideInput")
    public void testDivision(double input1, double input2, double expected) {
        if (input2 != 0) {
            logger.info(input2 + " is not equal to zero hence proceeding for division");
            double result = calculator.div(input1, input2);
            assertEquals(expected, result);
            loggerExtent = extent.startTest("testDivision");
            loggerExtent.log(LogStatus.PASS, "Test Case Passed is passTest");
        } else {
            logger.error("Could not proceed with division for " + input2 + " value ");
            loggerExtent.log(LogStatus.FAIL, "Test Case Passed is failed passTest");
        }
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            loggerExtent.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            loggerExtent.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            loggerExtent.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(loggerExtent);
    }

    /**
     * De-initialize instance of calculator class
     *
     * @throws Exception
     */
    @AfterClass
    public void tearDown() throws Exception {
        calculator = null;
    }
}
