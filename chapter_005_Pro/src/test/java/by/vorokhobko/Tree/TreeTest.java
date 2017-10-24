package by.vorokhobko.tree;

import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 22.07.2017.
 */
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
    public void whenBinaryElementsInMap() {
        tree.add(1, 3);
        tree.add(1, 4);
        assertThat(tree.isBinary(), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void whenNotBinaryElementsInMap() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);
        tree.add(0, 5);
        assertThat(tree.isBinary(), is(false));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorGoToTree() {
        tree.add(1, 3);
        assertThat(iterator.next(), is(3));
    }
    /**
     * Test.
     */
    @Test
    public void whenIteratorGoToTreeTrue() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 6);
        assertThat(iterator.hasNext(), is(true));
    }
}