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
        return evenNumbers() != 0;
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        return hasNext() ? evenNumbers() : null;
    }
    /**
     * Override method hasNext.
     * @return tag.
     */
    public int evenNumbers() {
        int value = 0;
        for (int index = 0; index < arrays.length; index++) {
            if (arrays[index] % 2 == 0) {
                value = arrays[index];
            }
        }
        return value;
    }
}