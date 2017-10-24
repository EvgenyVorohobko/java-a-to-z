package by.vorokhobko.list;

/**
 * DynamicStack.
 *
 * Class DynamicStack create the Stack for 005_Pro, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 27.06.2017.
 * @version 1.
 * @param <E>.
 */
public class DynamicStack<E> {
    /**
     * The class field.
     */
    private DynamicLinkedList<E> linked = new DynamicLinkedList<>();
    /**
     * Add objects in Stack.
     * @param value - value.
     */
    public void push(E value) {
        linked.add(value);
    }
    /**
     * Get top position in Stack and remove that.
     * @throws InvalidOperationException tag.
     * @return tag.
     */
    public E pop() throws InvalidOperationException {
        if (getCount() != 0) {
            E result = linked.get(linked.size() - 1);
            linked.remove();
            return result;
        } else {
            throw new InvalidOperationException("The stack is empty!");
        }
    }
    /**
     * Get top position in Stack.
     * @throws InvalidOperationException tag.
     * @return tag.
     */
    public E peek() throws InvalidOperationException {
        if (getCount() != 0) {
            E result = linked.get(linked.size() - 1);
            return result;
        } else {
            throw new InvalidOperationException("The stack is empty!");
        }
    }
    /**
     * Get positions in Stack.
     * @return tag.
     */
    public int getCount() {
        return linked.size();
    }
}