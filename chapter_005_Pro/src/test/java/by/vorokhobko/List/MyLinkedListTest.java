package by.vorokhobko.List;

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
 * @since 25.06.2017.
 */
public class MyLinkedListTest {
    /**
     * Test.
     */
    @Test
    public void whenAddElementInLinked() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Iterator<Integer> iter = list.iterator();
        list.add(4);
        iter.next();
        list.add(5);
        assertThat(iter.hasNext(), is(true));
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is(4));
    }
    /**
     * Test.
     */
    @Test
    public void whenNextElementDoNotLinked() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Iterator<Integer> iter = list.iterator();
        list.add(4);
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }
    /**
     * Test by Exception.
     * @throws NoSuchElementException tag.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNotElementInLinked() throws NoSuchElementException {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Iterator<Integer> iter = list.iterator();
        list.add(4);
        list.add(5);
        iter.next();
        iter.next();
        iter.next();
    }
}