package test;

import com.epam.tat.module4.Calculator;

public class Bugs {

	public static void main(String[] args) {
		Calculator calc = new Calculator();

		System.out.println("sin value : " + calc.sin(90));

		System.out.println("cos value : " + calc.cos(90)); // Bug in COS -
															// Working similar
															// to sin

		System.out.println("tan value : " + calc.tg(90));// Bug in TAN - always
															// returns 1 as
															// output

		System.out.println("cot value : " + calc.ctg(90));// Bug in COT - Not
															// returning correct
															// value

		System.out.println(calc.pow(2, 3));

		System.out.println(calc.isPositive(-5));

		System.out.println(calc.div(10, 5));

		System.out.println(calc.isNegative(5));

		System.out.println(calc.sqrt(9));
	}
}
