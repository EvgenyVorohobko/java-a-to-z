package by.vorokhobko.Iterator;

import java.util.Iterator;

/**
 * IteratorEvenNumbers.
 *
 * Class IteratorEvenNumbers return even numbers on massive 005_Pro, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 16.06.2017.
 * @version 1.
 */
public class IteratorEvenNumbers implements Iterator {
    /**
     * The class field.
     */
    private final int[] arrays;
    /**
     * The class field.
     */
    private int count;
    /**
     * Add constructor.
     * @param arrays - arrays.
     */
    public IteratorEvenNumbers(int[] arrays) {
        this.arrays = arrays;
    }
    /**
     * Override method hasNext.
     * @return tag.
     */
    @Override
    public boolean hasNext() {
        boolean isNeedSave = false;
        if (arrays.length > count) {
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
        int value = 0;
        while (hasNext()) {
            if (arrays[count] % 2 == 0) {
                value = arrays[count];
            }
            count++;
        }
        return value;
    }
}