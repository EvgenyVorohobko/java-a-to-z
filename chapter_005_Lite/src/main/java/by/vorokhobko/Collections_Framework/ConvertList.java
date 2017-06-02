package by.vorokhobko.Collections_Framework;

import java.util.ArrayList;
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
     * The method add element in collections.
     * @param list - list.
     * @param rows - rows.
     * @return tag.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[list.size() / 2][list.size() / 2];
        rows = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            for (int j = 0; j < list.size() / 2; j++) {
                if (rows == list.size()) {
                    rows = 0;
                    break;
                }
                array[i][j] = list.get(rows);
                rows++;
            }
        }
        return array;
    }
}