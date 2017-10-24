package by.vorokhobko.list;

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
public class DynamicQueueTest {
    /**
     * The class field.
     */
    private DynamicQueue<Integer> queue = new DynamicQueue<>();
    /**
     * Test.
     * @throws InvalidOperationException tag.
     */
    @Test
    public void whenAddElementInStack() throws InvalidOperationException  {
        queue.enqueue(4);
        queue.enqueue(3);
        assertThat(queue.peek(), is(4));
        assertThat(queue.getCount(), is(2));
    }
    /**
     * Test by exception.
     * @throws InvalidOperationException tag.
     */
    @Test(expected = InvalidOperationException.class)
    public void whenNotElementInStack() throws InvalidOperationException {
        queue.peek();
    }
    /**
     * Test.
     * @throws InvalidOperationException tag.
     */
    @Test
    public void whenDeleteElementInStack() throws InvalidOperationException  {
        queue.enqueue(4);
        queue.enqueue(3);
        queue.dequeue();
        assertThat(queue.getCount(), is(1));
    }
}
