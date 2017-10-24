package by.vorokhobko.list;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 25.06.2017.
 */
public class DynamicStackTest {
    /**
     * The class field.
     */
    private DynamicStack<Integer> stack = new DynamicStack<>();
    /**
     * Test.
     * @throws InvalidOperationException tag.
     */
    @Test
    public void whenAddElementInStack() throws InvalidOperationException  {
        stack.push(4);
        stack.push(3);
        assertThat(stack.peek(), is(3));
        assertThat(stack.getCount(), is(2));
    }
    /**
     * Test by exception.
     * @throws InvalidOperationException tag.
     */
    @Test(expected = InvalidOperationException.class)
    public void whenNotElementInStack() throws InvalidOperationException {
        stack.peek();
    }
    /**
     * Test.
     * @throws InvalidOperationException tag.
     */
    @Test
    public void whenDeleteElementInStack() throws InvalidOperationException  {
        stack.push(4);
        stack.push(3);
        stack.pop();
        assertThat(stack.getCount(), is(1));
    }
}