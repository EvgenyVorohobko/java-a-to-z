package by.vorokhobko.Collections_Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConvertList.
 *
 * Class ConvertList converts a two-dimensional array to ArrayList and and Vice versa 005_Lite, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 02.06.2017.
 * @version 1.
 */
public class ConvertList {
    /**
     * The method add element in collections.
     * @param array - array.
     * @return tag.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
    /**
     * The method add element to array.
     * @param list - list.
     * @param rows - rows.
     * @return tag.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        float count = (float)list.size() / rows;
        int columns = (int) count;
        if (count > columns) {
            columns++;
        }
        int[][] array = new int[rows][columns];
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (iter.hasNext()) {
                    array[i][j] = iter.next();
                }
            }
        }
        return array;
    }
}