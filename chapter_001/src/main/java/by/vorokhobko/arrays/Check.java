package by.vorokhobko.arrays;

/**
 * Check.
 *
 * Class Check calculates that all the elements in the array are true or false, part 001, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 17.01.2019.
 * @version 1.
 */
public class Check {
    /**
     * The class field.
     * The method should check that all the elements in the array are true or false.
     * @param data - data.
     * @return tag.
     */
    public boolean mono(boolean[] data) {
        boolean result = data[0];
        for (boolean second : data) {
            if (result == second) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}