package by.vorokhobko.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 28.06.2017.
 */
public class CyclicalLinkedListTest {
    /**
     * The class field.
     */
    private CyclicalLinkedList cycle = new CyclicalLinkedList();
    /**
     * The class field.
     */
    private CyclicalLinkedList.Node oneNode = new CyclicalLinkedList.Node(1);
    /**
     * The class field.
     */
    private CyclicalLinkedList.Node twoNode = new CyclicalLinkedList.Node(2);
    /**
     * The class field.
     */
    private CyclicalLinkedList.Node thirdNode = new CyclicalLinkedList.Node(3);
    /**
     * The class field.
     */
    private CyclicalLinkedList.Node fourNode = new CyclicalLinkedList.Node(4);
    /**
     * Test.
     */
    @Test
    public void whenHaveCycle() {
        oneNode.setNext(twoNode);
        twoNode.setNext(thirdNode);
        thirdNode.setNext(fourNode);
        fourNode.setNext(oneNode);
        assertThat(cycle.hasCycle(oneNode), is(true));
    }
    /**
     * Test.
     */
    @Test
    public void whenHaveNotCycle() {
        oneNode.setNext(twoNode);
        twoNode.setNext(thirdNode);
        thirdNode.setNext(fourNode);
        assertThat(cycle.hasCycle(fourNode), is(false));
    }
}