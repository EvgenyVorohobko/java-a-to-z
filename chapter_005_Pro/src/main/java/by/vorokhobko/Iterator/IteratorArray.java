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
     * The class field.
     */
    private int index;
    /**
     * Override method hasNext.
     * @return tag.
     */
    @Override
    public boolean hasNext() {
        boolean isNeedSave = false;
        if (arrays.length > count) {
            if (arrays[value].length > index)
            isNeedSave = true;
        }
        return isNeedSave;
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return arrays[count][value];
        } else {
            throw new NoSuchElementException("No such element");
        }
    }
    /**
     * Add constructor.
     * @param array - array.
     */
    public IteratorArray(final int[][] array) {
        this.arrays = array;
    }
}