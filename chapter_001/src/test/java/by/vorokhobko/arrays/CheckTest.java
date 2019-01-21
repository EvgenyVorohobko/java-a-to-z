package by.vorokhobko.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 17.01.2019.
 */
public class CheckTest {
    /**
     * The class field.
     */
    private Check check = new Check();
    /**
     * @Test.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        boolean[] input = new boolean[] {true, true, true};
        boolean result = this.check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * @Test.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        boolean[] input = new boolean[] {true, false, true};
        boolean result = this.check.mono(input);
        assertThat(result, is(false));
    }
}