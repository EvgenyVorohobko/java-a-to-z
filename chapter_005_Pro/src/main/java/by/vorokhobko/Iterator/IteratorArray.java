package by.vorokhobko.Iterator;

import java.util.Iterator;

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
            if (arrays[count].length > value) {
                isNeedSave = true;
            }
        }
        return isNeedSave;
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        int result = 0;
        for (count = 0; count < arrays.length; count++) {
            for (value = 0; value < arrays[count].length; value++) {
                    result = arrays[count][value];
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