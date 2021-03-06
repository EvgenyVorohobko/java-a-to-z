package by.vorokhobko.datatypes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;

/**
 * CalculatorTest.
 *
 * Class CalculatorTest for testing class Calculator.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.11.2016.
 * @version 1.
 */

 public class CalculatorTest {
	 /**
	  * numberExeption.
	  */
	private final double numberExeption = 0.1;
	 /**
	  * @Test.
	  * Add test with positive numbers.
	  */
	  @Test
	public void testWhenPassArgToAddPositiveNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 2;
		final double second = 2;
		final double resultingNumber = 4;
		calc.add(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	  /**
	  * @Test.
	  * Add test with negative numbers.
	  */
	  @Test
	public void testWhenPassArgToAddNegativNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = -2;
		final double second = -2;
		final double resultingNumber = -4;
		calc.add(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	  /**
	  * @Test.
	  * Add test with second negative number and first positive number.
	  */
	  @Test
	public void testWhenPassArgToAddItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 4;
		final double second = -2;
		final double resultingNumber = 2;
		calc.add(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	  * @Test.
	  * Take test with positive numbers.
	  */
	  @Test
	public void testWhenPassArgToTakePositiveNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 4;
		final double second = 2;
		final double resultingNumber = 2;
		calc.take(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	  * @Test.
	  * Take test with negative numbers.
	  */
	  @Test
	public void testWhenPassArgToTakeNegativeNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = -4;
		final double second = -2;
		final double resultingNumber = -2;
		calc.take(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	  /**
	  * @Test.
	  * Take test with second negative number and first positive number.
	  */
	  @Test
	public void testWhenPassArgToTakeItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 4;
		final double second = -2;
		final double resultingNumber = 6;
		calc.take(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	/**
	 * @Test.
	 * Multiple test with positive numbers.
	 */
	 @Test
	public void testWhenPassArgToMultPositiveNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 3;
		final double second = 2;
		final double resultingNumber = 6;
		calc.mult(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	 * @Test.
	 * Multiple test with negative numbers.
	 */
	 @Test
	public void testWhenPassArgToMultNegativeNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = -3;
		final double second = -2;
		final double resultingNumber = 6;
		calc.mult(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	 * @Test.
	 * Multiple test with first positive number and second negative number.
	 */
	 @Test
	public void testWhenPassArgToMultItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 3;
		final double second = -2;
		final double resultingNumber = -6;
		calc.mult(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	/**
	 * @Test.
	 * Sharing test with positive numbers.
	 */
	 @Test
	public void testWhenPassArgToSharPositiveNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 10;
		final double second = 2;
		final double resultingNumber = 5;
		calc.shar(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	 * @Test.
	 * Sharing test with negative numbers.
	 */
	 @Test
	public void testWhenPassArgToSharNegativeNumbersItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = -10;
		final double second = -2;
		final double resultingNumber = 5;
		calc.shar(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
	 /**
	 * @Test.
	 * Sharing test with first number and second zero.
	 */
	 @Test(expected = ArithmeticException.class)
	public void testWhenPassArgToSharToZeroItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 10;
		final double second = 0;
		calc.shar(first, second);
		double result = calc.getResult();
	  }
 }