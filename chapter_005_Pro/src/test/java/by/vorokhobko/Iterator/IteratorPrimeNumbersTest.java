package by.vorokhobko.iterator;

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
public class IteratorPrimeNumbersTest {
    /**
     * Test.
     */
    @Test
    public void whenIteratorReturnPrimeNumbers() {
        IteratorPrimeNumbers prime = new IteratorPrimeNumbers(new int[] {8, 1, 2, 11, 4, 5, 3, 4, 18, 71, 73, 100});
        int result = (Integer) prime.next();
        assertThat(result, is(73));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorDoNotReturnPrimeNumbers() {
        IteratorPrimeNumbers prime = new IteratorPrimeNumbers(new int[] {4, 4, 4, 4, 18, 10, 16, 6});
        boolean result = prime.hasNext();
        assertThat(result, is(false));
    }
}