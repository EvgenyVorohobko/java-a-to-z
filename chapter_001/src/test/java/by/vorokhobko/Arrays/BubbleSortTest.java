package by.vorokhobko.Arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 21.12.2016.
 */

public class BubbleSortTest {
     /**
     * @Test.
     */
    @Test
	public void sortArrayWithAnEvenNumberOfElements() {
		final BubbleSort bs = new BubbleSort();
		final int[] values = new int[]{5, 10, 2, 1};
		final int[] resultArray = bs.sorting(values);
		final int[] expectArray = new int[]{1, 2, 5, 10};
		assertThat(resultArray, is(expectArray));
	}
	 /**
     * @Test.
     */
    @Test
	public void sortArrayWithOddNumberOfElements() {
		final BubbleSort bs = new BubbleSort();
		final int[] values = new int[]{5, 10, 2, 1, -3};
		final int[] resultArray = bs.sorting(values);
		final int[] expectArray = new int[]{-3, 1, 2, 5, 10};
		assertThat(resultArray, is(expectArray));
	}
	 /**
     * @Test.
     */
    @Test
	public void sortArrayWithNegativeNumbers() {
		final BubbleSort bs = new BubbleSort();
		final int[] values = new int[]{-5, -10, -2, -1, -3};
		final int[] resultArray = bs.sorting(values);
		final int[] expectArray = new int[]{-10, -5, -3, -2, -1};
		assertThat(resultArray, is(expectArray));
	}
}