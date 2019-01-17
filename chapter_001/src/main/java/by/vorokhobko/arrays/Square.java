package by.vorokhobko.arrays;

/**
 * Square.
 *
 * Class Square calculates the numbers in the square, part 001, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.01.2019.
 * @version 1.
 */
public class Square {
    /**
     * The class field.
     * The method calculates the numbers in the square.
     * @param bound - values.
     * @return tag.
     */
    public int[] calculate(int bound) {
        if (bound < 0) {
            throw new NegativeArraySizeException();
        } else {
            int[] rst = new int[bound];
            for (int i = 0; i < rst.length; i++) {
                rst[i] = (int) Math.pow(i + 1, 2);
            }
            return rst;
        }
    }
}