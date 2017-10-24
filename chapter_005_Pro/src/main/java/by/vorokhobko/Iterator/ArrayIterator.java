package by.vorokhobko.iterator;

import java.util.Iterator;

/**
 * ArrayIterator.
 *
 * Class ArrayIterator for convert iterator 005_Pro, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 18.06.2017.
 * @version 1.
 */
public class ArrayIterator implements Iterator {
    /**
     * The class field.
     */
    private int[] array;
    /**
     * The class field.
     */
    private int count;
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        int result = 0;
        if (hasNext()) {
            result = array[count++];
        }
        return result;
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
     * Add constructor.
     * @param array - array.
     */
    public ArrayIterator(int[] array) {
        this.array = array;
    }
}