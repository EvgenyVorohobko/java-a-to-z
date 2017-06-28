package by.vorokhobko.List;

/**
 * CyclicalLinkedList.
 *
 * Class CyclicalLinkedList to determine the cyclical for 005_Pro, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 28.06.2017.
 * @version 1.
 * @param <T>.
 */
public class CyclicalLinkedList<T> {
    /**
     * Node.
     *
     * Class Node for start CyclicalLinkedList 005_Pro, lesson 3.
     * @param <T>.
     */
    public static class Node<T> {
        /**
         * The class field.
         */
        private T value;
        /**
         * The class field.
         */
        private Node<T> next;
        /**
         * Add constructor.
         * @param value - value.
         */
        public Node(T value) {
            this.value = value;
        }
        /**
         * Add setter nextElement.
         * @param next - next.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
        /**
         * Add getter next.
         * @return tag.
         */
        public Node<T> getNext() {
            return next;
        }
    }
    /**
     * Method return true if have cycle.
     * @param first - first.
     * @return tag.
     */
    public boolean hasCycle(Node first) {
        boolean isNeedSave = false;
        Node count = first.getNext();
        if (first == null) {
            isNeedSave = false;
        }
        while ((first = count) != null) {
            if (first.equals(count)) {
                isNeedSave = true;
                break;
            }
        }
        return isNeedSave;
    }
}