package by.vorokhobko.map;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 17.07.2017.
 */
public class ReferenceTest {
    /**
     * The class field.
     */
    private Reference<Integer, Integer> map = new Reference<>();
    /**
     * The class field.
     */
    private Iterator<Integer> iter = map.iterator();
    /**
     * The class field.
     */
    private static final int SIZE = 150;
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInMap() {
        map.insert(1, 2);
        map.insert(2, 4);
        assertThat(map.get(1), is(2));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInMapAndElementHaveInMap() {
        map.insert(1, 2);
        map.insert(1, 3);
        assertThat(map.get(1), is(3));
        assertThat(map.size(), is(1));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddManyElementsInMap() {
        for (int i = 0; i < SIZE; i++) {
            map.insert(i, i + 1);
        }
        assertThat(map.size(), is(150));
    }
    /**
     * Test.
     * @throws NullPointerException tag.
     */
    @Test(expected = NullPointerException.class)
    public void whenDeleteElementsInMap() throws NullPointerException {
        map.insert(1, 2);
        map.insert(2, 4);
        map.delete(2);
        map.get(2);
    }
    /**
     * Test.
     * @throws NullPointerException tag.
     */
    @Test(expected = NullPointerException.class)
    public void whenDeleteNullElementsInMap() throws NullPointerException {
        assertThat(map.delete(2), is(false));
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteFirstElementsInMap() {
        map.insert(1, 2);
        boolean isNeedSave = map.delete(1);
        assertThat(true, is(isNeedSave));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddCollisionInMap() {
        map.insert(1, 2);
        map.insert(2, 4);
        map.insert(2, 5);
        assertThat(map.get(2), is(5));
    }
    /**
     * Test.
     */
    @Test
    public void whenAddCollisionInMapAllIdentifaiLine() {
        map.insert(1, 2);
        map.insert(2, 4);
        map.insert(2, 4);
        assertThat(map.get(2), is(4));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorGoToMap() {
        map.insert(1, 2);
        map.insert(2, 4);
        boolean isNeedSave = iter.hasNext();
        Integer number = iter.next();
        assertThat(true, is(isNeedSave));
        assertThat(number, is(4));
    }
    /**
     * Test.
     */
    @Test
    public void whenHasNextReturnFalse() {
        boolean isNeedSave = iter.hasNext();
        assertThat(false, is(isNeedSave));
    }
}