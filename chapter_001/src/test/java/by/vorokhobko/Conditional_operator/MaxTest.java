package by.vorokhobko.Conditional_operator;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 *
 * Class MaxTest for testing class Max part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 06.12.2016.
 * @version 1.
 */
public class MaxTest {
	  /**
	  * @Test.
	  * Max test positive numbers.
	  */
	  @Test
	  public void methodDeterminesTheMaxInPositiveNumbers() {
			Max max = new Max();
			final int first = 1;
			final int second = 2;
			final int resultingNumber = 2;
			int result = max.max(first, second);
			assertThat(result, is(resultingNumber));
	  }
	  /**
	  * @Test.
	  * Max test negative numbers.
	  */
	  @Test
	  public void methodDeterminesTheMaxInNegativeNumbers() {
			Max max = new Max();
			final int first = -1;
			final int second = -2;
			final int resultingNumber = -1;
			int result = max.max(first, second);
			assertThat(result, is(resultingNumber));
	  }
	  /**
	  * @Test.
	  * Max test negative number and positive number.
	  */
	  @Test
	  public void methodDeterminesTheMaxNumber() {
			Max max = new Max();
			final int first = 1;
			final int second = -2;
			final int resultingNumber = 1;
			int result = max.max(first, second);
			assertThat(result, is(resultingNumber));
	  }
	  /**
	  * @Test.
	  * Max test equal numbers.
	  */
	  @Test
	  public void methodDeterminesTheMax() {
			Max max = new Max();
			final int first = 2;
			final int second = 2;
			final int resultingNumber = 2;
			int result = max.max(first, second);
			assertThat(result, is(resultingNumber));
	  }
}