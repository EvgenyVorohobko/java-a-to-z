package by.vorokhobko.Set;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 05.07.2017.
 */
public class SimpleSetLInkedListTest {
    /**
     * The class field.
     */
    private SimpleSetLinkedList<Integer> set = new SimpleSetLinkedList<>();
    /**
     * The class field.
     */
    private Iterator<Integer> iter = set.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementInLinked() {
        set.addList(4);
        set.addList(3);
        set.addList(5);
        set.addList(9);
        assertThat(set.getElement(0), is(3));
        assertThat(set.getElement(3), is(9));
    }
    /**
     * Test.
     */
    @Test
    public void whenNextElementDoNotLinked() {
        set.addList(4);
        assertThat(iter.hasNext(), is(true));
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }
    /**
     * Test by Exception.
     * @throws NoSuchElementException tag.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNotElementInLinked() throws NoSuchElementException {
        set.addList(4);
        set.addList(5);
        iter.next();
        iter.next();
        iter.next();
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteElementInLinked() {
        set.addList(4);
        set.addList(5);
        assertThat(set.size(), is(2));
    }
}