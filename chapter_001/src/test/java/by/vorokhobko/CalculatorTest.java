package by.vorokhobko;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

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
	  * Add test.
	  */
	public void testWhenPassArgToAddItShouldReturn() {
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
	  * Take test.
	  */
	public void testWhenPassArgToTakeItShouldReturn() {
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
	 * Multiple test.
	 */
	public void testWhenPassArgToMultItShouldReturn() {
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
	 * Sharing test.
	 */
	public void testWhenPassArgToSharItShouldReturn() {
		Calculator calc = new Calculator();
		final double first = 10;
		final double second = 2;
		final double resultingNumber = 5;
		calc.shar(first, second);
		double result = calc.getResult();
		assertThat(result, is(closeTo(resultingNumber, numberExeption)));
	  }
 }