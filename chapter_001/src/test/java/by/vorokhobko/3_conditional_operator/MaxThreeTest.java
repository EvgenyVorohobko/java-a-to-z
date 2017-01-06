package by.vorokhobko.3_conditional_operator;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 *
 * Class MaxTest for testing class Max part 001, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 07.12.2016.
 * @version 1.
 */
public class MaxThreeTest {
	  /**
	  * @Test.
	  * MaxThree test positive numbers.
	  */
	  @Test
	  public void methodDeterminesTheMaxInPositiveNumbers() {
			MaxThree max = new MaxThree();
			final int first = 1;
			final int second = 2;
			final int third = 3;
			final int resultingNumber = 3;
			int result = max.maxThree(first, second, third);
			assertThat(result, is(resultingNumber));
	  }
	  /**
	  * @Test.
	  * MaxThree test negative numbers.
	  */
	  @Test
	  public void methodDeterminesTheMaxInNegativeNumbers() {
			MaxThree max = new MaxThree();
			final int first = -1;
			final int second = -2;
			final int third = -3;
			final int resultingNumber = -1;
			int result = max.maxThree(first, second, third);
			assertThat(result, is(resultingNumber));
	  }
	  /**
	  * @Test.
	  * MaxThree test negative number and positive number.
	  */
	  @Test
	  public void methodDeterminesTheMaxNumber() {
			MaxThree max = new MaxThree();
			final int first = -1;
			final int second = 2;
			final int third = -3;
			final int resultingNumber = 2;
			int result = max.maxThree(first, second, third);
			assertThat(result, is(resultingNumber));
	  }
}