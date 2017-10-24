package by.vorokhobko.set;

import org.junit.Test;
import java.util.Iterator;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 14.07.2017.
 */
public class FastSimpleSetTest {
    /**
     * The class field.
     */
    private FastSimpleSet<Integer> set = new FastSimpleSet<>();
    /**
     * The class field.
     */
    private static final int SIZE = 100;
    /**
     * The class field.
     */
    private SimpleSetArray<Integer> setArray = new SimpleSetArray<>(SIZE);
    /**
     * The class field.
     */
    private Iterator<Integer> iter = setArray.iterator();
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInArrayTime1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            set.add(i);
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println(timeWorkCode);
    }
    /**
     * Test.
     */
    @Test
    public void whenAddElementsInArrayTime2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            setArray.add(i);
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println(timeWorkCode);
    }
}