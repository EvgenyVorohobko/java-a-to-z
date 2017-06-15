package by.vorokhobko.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IteratorArray.
 *
 * Class IteratorArray for go to iterator on massive 005_Pro, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.06.2017.
 * @version 1.
 */
public class IteratorArray implements Iterator {
    /**
     * The class field.
     */
    private final int[][] arrays;
    /**
     * The class field.
     */
    private int count;
    /**
     * The class field.
     */
    private int value;
    /**
     * Override method hasNext.
     * @return tag.
     */
    @Override
    public boolean hasNext() {
        return arrays.length > count;
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        int result = 0;
        if (hasNext()) {
            if (arrays[count].length > value) {
                result = arrays[count++][value++];
            } else {
                throw new NoSuchElementException("No such element");
            }
        }
        return result;
    }
    /**
     * Add constructor.
     * @param array - array.
     */
    public IteratorArray(final int[][] array) {
        this.arrays = array;
    }
}