package by.vorokhobko.Arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
* @since 23.12.2016.
* @version 1.
*/

public class TransponeTest {
    /**
     * @Test.
     */
    @Test
	public void whenMassifSquare() {
		final Transpone tr = new Transpone();
		final int[][] array = new int[][] {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		final int[][] resultArray = tr.transpone(array);
		final int[][] expectArray = new int[][] {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		assertThat(resultArray, is(expectArray));
	}
}