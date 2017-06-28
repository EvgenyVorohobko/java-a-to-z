package by.vorokhobko.List;

/**
 * DynamicQueue.
 *
 * Class DynamicQueue create the Queue for 005_Pro, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 28.06.2017.
 * @version 1.
 * @param <E>.
 */
public class DynamicQueue<E> {
    /**
     * The class field.
     */
    private DynamicLinkedList<E> linked = new DynamicLinkedList<>();
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * Add objects in Queue.
     * @param value - value.
     */
    public void enqueue(E value) {
        linked.add(value);
    }
    /**
     * Get top position in Queue and remove that.
     * @throws InvalidOperationException tag.
     * @return tag.
     */
    public E dequeue() throws InvalidOperationException {
        if (getCount() != 0) {
            E result = linked.get(count++);
            linked.remove();
            return result;
        } else {
            throw new InvalidOperationException("The stack is empty!");
        }
    }
    /**
     * Get top position in Queue.
     * @throws InvalidOperationException tag.
     * @return tag.
     */
    public E peek() throws InvalidOperationException {
        if (getCount() != 0) {
            E result = linked.get(count++);
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