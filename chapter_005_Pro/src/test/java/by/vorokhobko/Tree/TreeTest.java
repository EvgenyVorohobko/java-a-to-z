package by.vorokhobko.Tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    /**
     * The class field.
     */
    private Tree<Integer> tree = new Tree<>();
    /**
     * The class field.
     */
    private Iterator<Integer> iterator = tree.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInMap() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
    }
}