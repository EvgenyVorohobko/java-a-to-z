package by.vorokhobko.Control_questions;

import org.junit.Test;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.09.2017.
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
    }
    /**
     * Test.
     */
    @Test
    public void whenCompareStringAndHaveFalse() {
        String text1 = "исскуство";
        String text2 = "забор";
        this.run.compareString(text1, text2);
    }
}