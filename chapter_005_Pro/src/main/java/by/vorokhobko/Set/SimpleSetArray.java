package by.vorokhobko.Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleSetArray.
 *
 * Class SimpleSetArray create the containers SimpleSet for Array 005_Pro, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.07.2017.
 * @version 1.
 * @param <E>.
 */
public class SimpleSetArray<E> implements Iterable {
    /**
     * The class field.
     */
    private static final int INIT_ARRAY = 10;
    /**
     * The class field.
     */
    private Object[] array = new Object[INIT_ARRAY];
    /**
     * The class field.
     */
    private int count = 0;
    /**
     * Add constructor.
     * @param size - size.
     */
    public SimpleSetArray(int size) {
        this.array = new Object[size];
    }
    /**
     * Add bjects in array.
     * @param e - e.
     */
    public void add(E e) {
        if (count == array.length - 1) {
            resize(array.length * 3 / 2 + 1);
        }
        if (array[count] == null) {
            this.array[count] = e;
            count++;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == null) {
                    break;
                }
                if (array[i].equals(array[j])) {
                    System.out.println("This object is already in the array!");
                    iterator().remove();
                    break;
                }
            }
        }
        sortByHashCode();
    }
    /**
     * Method sort element in array by hashCode.
     */
    private void sortByHashCode() {
        for (int x = array.length - 1; x > 0; x--) {
            for (int y = 0; y < x; y++) {
                if (array[y + 1] != null) {
                    if (array[y].hashCode() > array[y + 1].hashCode()) {
                        Object values = array[y];
                        array[y] = array[y + 1];
                        array[y + 1] = values;
                    }
                }
            }
        }
    }
    /**
     *
     * Get position in object.
     * @param index - index.
     * @return tag.
     */
    public E get(int index) {
        return (E) this.array[index];
    }
    /**
     * Helper method to add an element.
     * @param size - size.
     */
    public void resize(int size) {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }
    /**
     * Override iterator constructor.
     * @return tag.
     */
    @Override
    public Iterator iterator() {
        return new IteratorForSet<E>();
    }
    /**
     * IteratorForSet.
     *
     * Class IteratorForSet create own implementation of the iterator.
     * @param <E>.
     */
    public class IteratorForSet<E> implements Iterator {
        /**
         * Override method remove.
         */
        @Override
        public void remove() {
            for (int i = count - 1; i < count; i++) {
                array[i] = array[i + 1];
            }
            array[count] = null;
            count--;
        }
        /**
         * Override method hasNext.
         * @return tag.
         */
        @Override
        public boolean hasNext() {
            boolean isNeedSave = false;
            if (array.length > count) {
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
                return (E) array[count++];
            } else {
                throw new NoSuchElementException("The objects in the array is no more!");
            }
        }
    }
}