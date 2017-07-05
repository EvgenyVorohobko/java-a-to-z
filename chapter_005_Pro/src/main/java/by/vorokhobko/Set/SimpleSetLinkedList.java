package by.vorokhobko.Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleSetLinkedList.
 *
 * Class SimpleSetLinkedList create the Set for 005_Pro, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.07.2017.
 * @version 1.
 * @param <E>.
 */
public class SimpleSetLinkedList<E> implements Iterable {
    /**
     * The class field.
     */
    private Node<E> firstNode;
    /**
     * The class field.
     */
    private Node<E> lastNode;
    /**
     * The class field.
     */
    private int size;
    /**
     * The class field.
     */
    private int counter = 0;
    /**
     * Add constructor.
     */
    public SimpleSetLinkedList() {
        this.lastNode = new Node<E>(firstNode, null, null);
        this.firstNode = new Node<E>(null, null, lastNode);
    }
    /**
     * Node.
     *
     * Class Node for start SimpleSetLinkedList 005_Pro, lesson 4.
     * @param <E>.
     */
    private class Node<E> {
        /**
         * The class field.
         */
        private E currentElement;
        /**
         * The class field.
         */
        private Node<E> nextElement;
        /**
         * The class field.
         */
        private Node<E> prevElement;
        /**
         * Add constructor.
         * @param currentElement - currentElement.
         * @param nextElement    - nextElement.
         * @param prevElement    - prevElement.
         */
        private Node(Node<E> prevElement, E currentElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
        /**
         * Add getter currentElement.
         * @return tag.
         */
        public E getCurrentElement() {
            return currentElement;
        }
        /**
         * Add setter currentElement.
         * @param currentElement - currentElement.
         */
        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }
        /**
         * Add getter currentElement.
         * @return tag.
         */
        public Node<E> getNextElement() {
            return nextElement;
        }
        /**
         * Add setter nextElement.
         * @param nextElement - nextElement.
         */
        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
    }
    /**
     * Add objects in SimpleSetLinkedList.
     * @param newElement - newElement.
     */
    public void add(E newElement) {
        Node<E> previous = this.lastNode;
        previous.setCurrentElement(newElement);
        lastNode = new Node<E>(previous, null, null);
        previous.setNextElement(lastNode);
        size++;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (iterator().hasNext()) {
                    if ((iterator().next().equals(newElement))) {
                        System.out.println("This object is already in the array!");
                        remove();
                        break;
                    }
                }
            }
        }
    }
    /**
     * Get object in SimpleSetLinkedList.
     * @param index - index.
     * @return tag.
     */
    public E get(int index) {
        if (index < size) {
            Node<E> target = firstNode.getNextElement();
            for (int i = 0; i < index; i++) {
                target = getNextElement(target);
            }
            return target.getCurrentElement();
        } else {
            throw new NoSuchElementException("The objects in the array is no more!");
        }
    }
    /**
     * Get help in get object.
     * @param current - current.
     * @return tag.
     */
    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }
    /**
     * Get size.
     * @return tag.
     */
    public int size() {
        return size;
    }
    /**
     * Delete element in SimpleSetLinkedList.
     * @return tag.
     */
    public E remove() {
        Node<E> delete = lastNode;
        if (delete != null) {
            return deleteElementInList(delete);
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Help for method remove in SimpleSetLinkedList.
     * @param delete - delete.
     * @return tag.
     */
    public E deleteElementInList(Node<E> delete) {
        final E element = delete.currentElement;
        final Node<E> prev = delete.prevElement;
        delete.currentElement = null;
        delete.prevElement = null;
        lastNode = prev;
        if (prev == null) {
            firstNode = null;
        } else {
            prev.nextElement = null;
        }
        size--;
        return element;
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator iterator() {
        return new IteratorForLinkedSet<E>();
    }
    /**
     * IteratorForLinkedSet.
     *
     * Class IteratorForLinkedSet create own implementation of the iterator.
     * @param <E>.
     */
    public class IteratorForLinkedSet<E> implements Iterator {
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public boolean hasNext() {
            return size > counter;
        }
        /**
         * Override method next.
         * @return tag.
         */
        @Override
        public Object next() {
            return get(counter++);
        }
    }
}