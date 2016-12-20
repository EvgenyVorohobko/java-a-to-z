package by.vorokhobko;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 20.12.2016.
 */

public class TurnTest {
    /**
     * @Test.
     */
    @Test
	public void coupArrayWhenAnEvenNumberOfNumbers() {
		final Turn turn = new Turn();
		final int[] numbers = new int[]{1, 2, 3, 4};
		final int[] resultArray = turn.back(numbers);
		final int[] expectArray = new int[] {4, 3, 2, 1};
		assertThat(resultArray, is(expectArray));
	}
	 /**
     * @Test.
     */
    @Test
	public void coupArrayWhenAnOddNumberOfNumbers() {
		final Turn turn = new Turn();
		final int[] numbers = new int[]{1, 2, 3, 4, 5};
		final int[] resultArray = turn.back(numbers);
		final int[] expectArray = new int[] {5, 4, 3, 2, 1};
		assertThat(resultArray, is(expectArray));
	}
	 /**
     * @Test.
     */
    @Test
	public void coupArrayWhenASingleNumber() {
		final Turn turn = new Turn();
		final int[] numbers = new int[]{1};
		final int[] resultArray = turn.back(numbers);
		final int[] expectArray = new int[] {1};
		assertThat(resultArray, is(expectArray));
	}
}