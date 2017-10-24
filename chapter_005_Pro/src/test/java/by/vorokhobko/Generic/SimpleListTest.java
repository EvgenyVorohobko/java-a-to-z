package by.vorokhobko.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.06.2017.
 */
public class SimpleListTest {
    /**
     * Test.
     */
    @Test
    public void whenCreateContainersShouldReturnTheSameType() {
        SimpleList<String> simple = new SimpleList<>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }
    /**
     * Test.
     */
    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleList<Integer> simple = new SimpleList<>(4);
        simple.add(10);
        int result = simple.get(0);
        assertThat(result, is(10));
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteObjectInArray() {
        SimpleList<Integer> simple = new SimpleList<>(4);
        simple.add(10);
        simple.add(11);
        simple.delete(11);
        int result = simple.get(0);
        assertThat(result, is(10));
        assertThat(null, is(simple.get(1)));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateObjectInArray() {
        SimpleList<Integer> simple = new SimpleList<>(4);
        simple.add(10);
        simple.add(11);
        simple.update(148, 1);
        int result = simple.get(1);
        assertThat(result, is(148));
    }
}