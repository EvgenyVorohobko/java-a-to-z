package by.vorokhobko.Iterator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 14.06.2017.
 */
public class IteratorArrayTest {
    /**
     * Test.
     */
    @Test
    public void whenIteratorToGoOnTheMassive() {
        IteratorArray ia = new IteratorArray(new int[][] {{1, 3}, {4, 7}});
        int result = (Integer) ia.next();
        assertThat(result, is(7));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorToNotGoOnTheMassive() {
        IteratorArray ia = new IteratorArray(new int[][] {{1}});
        boolean result = ia.hasNext();
        assertThat(result, is(true));
    }
}