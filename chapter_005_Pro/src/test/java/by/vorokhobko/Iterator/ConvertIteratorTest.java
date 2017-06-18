package by.vorokhobko.Iterator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 18.06.2017.
 */
public class ConvertIteratorTest {
    /**
     * Test.
     */
    @Test
    public void whenIteratorIteratorConvertToIterator() {
        Iterator<Integer> it1 = new ArrayIterator(new int[] {4, 2, 0, 4, 6, 4, 9});
        Iterator<Integer> it2 = new ArrayIterator(new int[] {0, 9, 8, 7, 5});
        Iterator<Integer> it3 = new ArrayIterator(new int[] {1, 3, 5, 6, 7, 0, 9, 8, 4});
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4}));
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();
        ConvertIterator convertIterator = new ConvertIterator(it);
        Iterator<Integer> iterator = convertIterator.convert(it);
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        assertThat(result, is(list));
    }
}