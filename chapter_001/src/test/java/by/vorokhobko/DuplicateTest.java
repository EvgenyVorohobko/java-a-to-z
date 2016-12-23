package by.vorokhobko;

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

public class DuplicateTest {
    /**
     * @Test.
     */
    @Test
	public void whenTheArrayOfTwoDuplicate() {
		final Duplicate d = new Duplicate();
		final String[] values = new String[]{"Привет", "Привет", "Мир", "Мир"};
		final String[] result = d.deleteDuplicate(values);
		final String[] expect = new String[]{"Привет", "Мир"};
		assertThat(result, is(expect));
	}
}