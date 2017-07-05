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
    private SimpleSetLinkedList list = new SimpleSetLinkedList();
    /**
     * The class field.
     */
    private Iterator<Integer> iter = list.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementInLinked() {
        list.add(4);
        list.add(5);
        assertThat(list.get(0), is(4));
        assertThat(list.get(1), is(5));
    }
    /**
     * Test.
     */
    @Test
    public void whenNextElementDoNotLinked() {
        list.add(4);
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
        list.add(4);
        list.add(5);
        iter.next();
        iter.next();
        iter.next();
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteElementInLinked() {
        list.add(4);
        list.add(5);
        list.remove();
        assertThat(list.size(), is(1));
    }
}