package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

public class CalculatorTest {
	private Calculator calc;

	@BeforeClass(groups = { "positive", "negative" })
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "addInput")
	public void testAdd(long a, long b, long expected) {
		long result = calc.sum(a, b);
		assertEquals(expected, result);

	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "subInput")
	public void testSub(long a, long b, long expected) {
		long result = calc.sub(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "mulInput")
	public void testMul(long a, long b, long expected) {
		long result = calc.mult(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "divideInput")
	public void testDiv(double a, double b, double expected) {
		double result = calc.div(a, b);
		assertEquals(expected, result);
	}

	@Test(groups = { "positive" }, dataProviderClass = DataForCalculation.class, dataProvider = "sqrtInput")
	public void testSqrt(double a, double expected) {
		double result = calc.sqrt(a);
		assertEquals(expected, result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "addNegInput")
	public void testNegAdd(long a, long b, long expected) {
		double result = calc.sum(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "subNegInput")
	public void testNegSub(long a, long b, long expected) {
		long result = calc.sub(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" },  dataProviderClass = DataForCalculation.class, dataProvider = "mulNegInput")
	public void testNegMul(long a, long b, long expected) {
		long result = calc.mult(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "divNegInput")
	public void testNegDiv(double a, double b, double expected) {
		double result = calc.div(a, b);
		assertFalse(expected == result);
	}

	@Test(groups = { "negative" }, dataProviderClass = DataForCalculation.class, dataProvider = "sqrtNegInput")
	public void testNegSqrt(double a, double expected) {
		double result = calc.sqrt(a);
		assertFalse(expected == result);
	}

	
	@AfterClass(groups = { "positive", "negative" })
	public void tearDown() throws Exception {
		calc = null;
	}
}
