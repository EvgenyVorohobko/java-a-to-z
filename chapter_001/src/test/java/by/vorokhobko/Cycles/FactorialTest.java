package by.vorokhobko.cycles;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
* FacorialTest.
*
* Class FactorialTest for testing class Factorial part 001, lesson 4.
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 10.12.2016.
* @version 1.
*/

public class FactorialTest {
	/**
	* @Test.
	* The method calculates the factorial.
	*/
	@Test
	public void computedFactorial() {
		Factorial fact = new Factorial();
		final int n = 6;
		final int totalFact = 120;
		int result = fact.mult(n);
		assertThat(result, is(totalFact));
	}
	/**
	* @Test.
	* The method calculates the factorial if n anyway 0.
	*/
	@Test
	public void computedFactorialZero() {
		Factorial fact = new Factorial();
		final int n = 0;
		final int totalFact = 1;
		int result = fact.mult(n);
		assertThat(result, is(totalFact));
	}
}