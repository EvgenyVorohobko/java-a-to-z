package by.vorokhobko.Collections_Framework;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 02.06.2017.
 */
public class ConvertListTest {
    /**
     * The class field.
     */
    private ConvertList list = new ConvertList();
    /**
     * Test.
     */
    @Test
    public void whenArrayConvertToList() {
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int[][] array = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}};
        List<Integer> execute = list.toList(array);
        assertThat(execute, is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenListConvertToArray() {
        int[][] result = {{10, 20, 30},
                          {40, 50, 60},
                          {70, 0, 0}};
        List<Integer> listArray = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        int row = 0;
        int[][] execute = list.toArray(listArray, row);
        assertThat(execute, is(result));
    }
}