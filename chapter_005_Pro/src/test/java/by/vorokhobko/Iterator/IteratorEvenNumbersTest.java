package by.vorokhobko.Iterator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 16.06.2017.
 */
public class IteratorEvenNumbersTest {
    /**
     * Test.
     */
    @Test
    public void whenIteratorReturnEvenNumbers() {
        IteratorEvenNumbers even = new IteratorEvenNumbers(new int[] {0, 1, 2, 3, 4, 5, 100, 86, 44, 57, 99});
        int result = (Integer) even.next();
        assertThat(result, is(44));
    }
}