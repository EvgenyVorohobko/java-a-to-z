package by.vorokhobko.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicArrayList.
 *
 * Class DynamicArrayList create the containers DynamicArrayList 005_Pro, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 24.06.2017.
 * @version 1.
 * @param <E>.
 */
public class DynamicArrayList<E> implements Iterable {
    /**
     * The class field.
     */
    private static final int INIT_ARRAY = 10;
    /**
     * The class field.
     */
    private Object[] container = new Object[INIT_ARRAY];
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * The class field.
     */
    private int index = 0;
    /**
     * Add constructor.
     * @param size - size.
     */
    public DynamicArrayList(int size) {
        this.container = new Object[size];
    }
    /**
     * Add generic T in objects.
     * @param value - value.
     */
    public void add(E value) {
        if (count == container.length - 1) {
            resize(container.length * 3 / 2 + 1);
        }
        this.container[count++] = value;
    }
    /**
     * Helper method to add an element.
     * @param size - size.
     */
    public void resize(int size) {
        Object[] newContainer = new Object[size];
        System.arraycopy(container, 0, newContainer, 0, count);
        container = newContainer;
    }
    /**
     * Get generic E in position.
     * @param index - index.
     * @return tag.
     */
    public E get(int index) {
        return (E) this.container[index];
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }
    /**
     * MyIterator.
     *
     * Class MyIterator create own implementation of the iterator.
     * @param <E>.
     */
    public class MyIterator<E> implements Iterator<E> {
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public boolean hasNext() {
            boolean isNeedSave = false;
            if (container.length > count) {
                isNeedSave = true;
            }
            return isNeedSave;
        }
        /**
         * Override method next.
         * @return tag.
         */
        @Override
        public E next() throws NoSuchElementException {
            if (hasNext()) {
                return (E) container[count++];
            } else {
                throw new NoSuchElementException("The objects in the array is no more!");
            }
        }
        /**
         * Override method remove.
         */
        @Override
        public void remove() {
            for (int i = index; i < count; i++) {
                container[i] = container[i + 1];
            }
            container[count] = null;
            count--;
        }
    }
}