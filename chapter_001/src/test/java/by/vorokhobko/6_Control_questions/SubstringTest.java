package by.vorokhobko.6_Control_questions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 03.01.2017.
 */

public class SubstringTest {
    /**
     * @Test.
     */
    @Test
    public void whenTheSubstringIsInTheString() {
		final Substring s = new Substring();
		final String origin = "The Empire strikes back";
		final String sub = "back";
		final boolean temp = true;
		final boolean result = s.contains(origin, sub);
		assertThat(result, is(temp));
	}
	/**
     * @Test.
     */
    @Test
    public void whenSubstringIsNotInString() {
		final Substring s = new Substring();
		final String origin = "The Empire strikes back";
		final String sub = "jedi";
		final boolean temp = false;
		final boolean result = s.contains(origin, sub);
		assertThat(result, is(temp));
	}
}