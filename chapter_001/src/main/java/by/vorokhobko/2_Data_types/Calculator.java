package by.vorokhobko.2_Data_types;

/**
 * Calculator.
 *
 * Class Calculate the solution of the problem part 001, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.11.2016.
 * @version 3.
 */

public class Calculator {

/**
 * The class field.
 */
 	private double result;
/**
 * getResult.
 * @return some value.
 */
	public double getResult() {
		return this.result;
	}
/**
 * Add numbers.
 * @param first - first.
 * @param second - second.
 */
	public void add(double first, double second) {
		this.result = first + second;
	}
/**
 * Take numbers.
 * @param first - first.
 * @param second - second.
 */
	public void take(double first, double second) {
		this.result = first - second;
	}
/**
 * Multiple numbers.
 * @param first - first.
 * @param second - second.
 */
	public void mult(double first, double second) {
		this.result = first * second;
	}
/**
 * Sharing numbers.
 * @param first - first.
 * @param second - second.
 */
	public void shar(double first, double second) {
		if (second != 0) {
			this.result = first / second;
		} else {
			throw new ArithmeticException("Cound not take by 0");
		}
	}
}