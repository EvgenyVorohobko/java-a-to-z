package by.vorokhobko.arrays;

/**
 * FindLoop.
 *
 * Class FindLoop calculates the numbers in the array, part 001, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.01.2019.
 * @version 1.
 */
public class FindLoop {
    /**
     * The class field.
     * The method calculates the numbers in the array.
     * @param data - data.
     * @param el - el.
     * @return tag.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == el) {
                rst = i;
            }
        }
        return rst;
    }
}