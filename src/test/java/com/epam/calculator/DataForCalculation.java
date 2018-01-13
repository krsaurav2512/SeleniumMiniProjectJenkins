package com.epam.calculator;

import org.testng.annotations.DataProvider;

/**
 * class to provide data for calculation
 */
public class DataForCalculation {
	/**
	 * below methods will provide inputs for Calculator test class methods
	 * @return
	 */
	@DataProvider(name = "addInput")
	public Object[][] getAddData() {
		return new Object[][] { { 2, 2, 4 }, { 2, 3, 5 }, { 5, 3, 8 } };
	}

	@DataProvider(name = "subInput")
	public Object[][] getSubData() {
		return new Object[][] { { 4, 2, 2 }, { 5, 3, 2 }, { 6, 3, 3 } };
	}

	@DataProvider(name = "mulInput")
	public Object[][] getMulData() {
		return new Object[][] { { 4, 2, 8 }, { 5, 3, 15 }, { 6, 3, 18 } };
	}

	@DataProvider(name = "divideInput")
	public Object[][] getDivideData() {
		return new Object[][] { { 4, 0, 2 }, { 6, 3, 2 }, { 15, 3, 5 } };
	}
}
