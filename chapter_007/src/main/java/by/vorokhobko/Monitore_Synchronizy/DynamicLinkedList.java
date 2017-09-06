package by.vorokhobko.Monitore_Synchronizy;

import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicLinkedList.
 *
 * Class DynamicLinkedList create the LinkedList for 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.09.2017.
 * @version 1.
 * @param <E>.
 */
@ThreadSafe
public class DynamicLinkedList<E> implements Iterable {
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
    public DynamicLinkedList() {
        lastNode = new Node<E>(firstNode, null, null);
        firstNode = new Node<E>(null, null, lastNode);
    }
    /**
     * Node.
     *
     * Class Node for start ContainerLinkedList 005_Pro, lesson 3.
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
         * Add setter currentElement.
         * @param currentElement - currentElement.
         */
        public synchronized void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }
        /**
         * Add getter currentElement.
         * @return tag.
         */
        public synchronized E getCurrentElement() {
            return currentElement;
        }
        /**
         * Add setter nextElement.
         * @param nextElement - nextElement.
         */
        public synchronized void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
        /**
         * Add getter nextElement.
         * @return tag.
         */
        public synchronized Node<E> getNextElement() {
            return nextElement;
        }
    }
    /**
     * Add generic T in objects.
     * @param value - value.
     */
    public synchronized void add(E value) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(value);
        lastNode = new Node<E>(prev, null, null);
        prev.setNextElement(lastNode);
        size++;
    }
    /**
     * Get generic E in position.
     * @param index - index.
     * @return tag.
     */
    public synchronized E get(int index)  {
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
     * Get generic E in position.
     * @return tag.
     */
    public synchronized E remove() {
        final Node<E> delete = lastNode;
        if (delete != null) {
            return deleteElementInList(delete);
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Get generic E in position.
     * @param delete - delete.
     * @return tag.
     */
    public synchronized E deleteElementInList(Node<E> delete) {
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
     * Get help in position.
     * @param current - current.
     * @return tag.
     */
    private synchronized Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }
    /**
     * Get size.
     * @return tag.
     */
    public synchronized int size() {
        return size;
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public synchronized Iterator iterator() {
        return new MyIteratorLinked<E>();
    }
    /**
     * MyIterator.
     *
     * Class MyIterator create own implementation of the iterator.
     * @param <E>.
     */
    public class MyIteratorLinked<E> implements Iterator {
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public synchronized boolean hasNext() {
            return counter < size;
        }
        /**
         * Override method next.
         * @return tag.
         */
        @Override
        public synchronized Object next() {
            return get(counter++);
        }
    }
}