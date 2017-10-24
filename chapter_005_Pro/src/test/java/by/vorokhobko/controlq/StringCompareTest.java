package by.vorokhobko.controlq;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 30.09.2017.
 */
public class StringCompareTest {
    /**
     * The class field.
     */
    private StringCompare run = new StringCompare();
    /**
     * Test.
     */
    @Test
    public void whenCompareStringAndHaveTrue() {
        String text1 = "полководец";
        String text2 = "полк";
        this.run.compareString(text1, text2);
        int count = 4;
        assertThat(4, is(count));
    }
    /**
     * Test.
     */
    @Test
    public void whenCompareStringAndHaveFalse() {
        String text1 = "исскуство";
        String text2 = "забор";
        this.run.compareString(text1, text2);
        int count = 7;
        assertThat(7, is(count));
    }
}