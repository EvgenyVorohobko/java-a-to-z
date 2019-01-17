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
public class FindLoopTest {
    /**
     * The class field.
     */
    private FindLoop find = new FindLoop();
    /**
     * @Test.
     */
    @Test
    public void whenArrayHasLength5Then0() {
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = this.find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    /**
     * @Test.
     */
    @Test
    public void whenArrayHasLength1Then_1() {
        int[] input = new int[] {5, 10, 3};
        int value = 1;
        int result = this.find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}