package by.vorokhobko.iterator;

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
        assertThat(ia.next(), is(1));
        ia.next();
        ia.next();
        assertThat(ia.next(), is(7));

    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorToNotGoOnTheMassive() {
        IteratorArray ia = new IteratorArray(new int[][] {{1}});
        ia.next();
        ia.hasNext();
        assertThat(ia.hasNext(), is(false));
    }
}