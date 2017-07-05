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
 * @since 03.07.2017.
 */
public class SimpleSetArrayTest {
    /**
     * The class field.
     */
    private SimpleSetArray set = new SimpleSetArray(4);
    /**
     * The class field.
     */
    private Iterator<Object> iter = set.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInArray() {
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(10);
        set.add(-1);
        assertThat(set.get(0), is(-1));
        assertThat(set.get(4), is(10));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddTwoOfTheSameElementsInArray() {
        set.add("object1");
        set.add("object1");
        assertThat(set.get(0), is("object1"));
        assertThat(null, is(set.get(1)));
    }
    /**
     * Test.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenNotNextElementsInArray() {
        set.add("object1");
        set.add("object2");
        iter.next();
        iter.next();
        iter.next();
    }
    /**
     * Test.
     */
    @Test
    public void whenHaveElementInArray() {
        set.add("object1");
        assertThat(iter.hasNext(), is(true));
        iter.next();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }
}