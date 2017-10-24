package by.vorokhobko.cycles;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * Class CounterTest for testing class Counter part 001, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 10.12.2016.
 * @version 1.
 */

 public class CounterTest {
	  /**
	  * @Test.
	  * Сalculates the sum of the even positive integers.
	  */
	  @Test
	  public void calculatesTheSumOfTheEvenPositiveIntegers() {
		  Counter count = new Counter();
		  final int start = 1;
		  final int finish = 11;
		  final int resultingSum = 30;
		  int result = count.add(start, finish);
		  assertThat(result, is(resultingSum));
	  }
	  /**
	  * @Test.
	  * Сalculates the sum of the even negative integers.
	  */
	  @Test
	  public void calculatesTheSumOfTheEvenNegativeIntegers() {
		  Counter count = new Counter();
		  final int start = -11;
		  final int finish = -1;
		  final int resultingSum = -30;
		  int result = count.add(start, finish);
		  assertThat(result, is(resultingSum));
	  }
	  /**
	  * @Test.
	  * Сalculates the sum of the even positive integers.
	  */
	  @Test
	  public void calculatesTheSumOfTheEvenIntegers() {
		  Counter count = new Counter();
		  final int start = -5;
		  final int finish = 5;
		  final int resultingSum = 0;
		  int result = count.add(start, finish);
		  assertThat(result, is(resultingSum));
	  }
 }