package by.vorokhobko.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IteratorPrimeNumbers.
 *
 * Class IteratorPrimeNumbers return prime numbers on massive 005_Pro, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 16.06.2017.
 * @version 1.
 */
public class IteratorPrimeNumbers implements Iterator {
    /**
     * The class field.
     */
    private final int[] array;
    /**
     * Add constructor.
     * @param array - array.
     */
    public IteratorPrimeNumbers(int[] array) {
        this.array = array;
    }
    /**
     * Override method hasNext.
     * @return tag.
     */
    @Override
    public boolean hasNext() {
        return primeNumber() != 0;
    }
    /**
     * Override method next.
     * @return tag.
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return primeNumber();
        } else {
            throw new NoSuchElementException(null);
        }
    }
    /**
     * Run method number prime.
     * @return tag.
     */
    public int primeNumber() {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int divider = 0;
            for (int j = 1; j <= array[i]; j++) {
                if (array[i] % j == 0) {
                    divider++;
                }
            }
            if (divider == 2) {
                result = array[i];
            }
        }
        return result;
    }
}