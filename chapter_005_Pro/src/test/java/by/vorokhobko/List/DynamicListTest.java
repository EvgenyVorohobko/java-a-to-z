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
 * @since 24.06.2017.
 */
public class DynamicListTest {
    /**
     * The class field.
     */
    private DynamicList list = new DynamicList(2);
    /**
     * The class field.
     */
    private Iterator<Object> iter = list.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementInArray() {
        list.add("object 1");
        list.add("object 2");
        list.add("object 3");
        assertThat(list.get(0), is("object 1"));
        assertThat(iter.hasNext(), is(true));
        assertThat(list.get(2), is("object 3"));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorToGoOnTheMassive() {
        list.add("object 1");
        iter.next();
        assertThat(iter.hasNext(), is(false));
    }
    /**
     * Test by Exception.
     * @throws NoSuchElementException tag.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNotElementInArray() throws NoSuchElementException {
        list.add("object 1");
        list.add("object 2");
        iter.next();
        iter.next();
        iter.next();
    }
    /**
     * Test.
     */
    @Test
    public void whenRemoveElementInArray() {
        list.add("object 1");
        list.add("object 2");
        if (iter.hasNext()) {
            iter.remove();
        }
        assertThat(list.get(0), is("object 2"));
    }
}