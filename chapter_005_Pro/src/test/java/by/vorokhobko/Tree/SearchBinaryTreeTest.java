package by.vorokhobko.Tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 24.07.2017.
 */
public class SearchBinaryTreeTest {
    /**
     * The class field.
     */
    private SearchBinaryTree<Integer> tree = new SearchBinaryTree<>();
    /**
     * Test.
     */
    @Test
    public void whenBinaryElementsInMap() {
        tree.add(8);
        tree.add(5);
        tree.add(10);
        tree.add(1);
        assertThat(tree.find(1), is(true));
        assertThat(tree.find(18), is(false));
    }
}