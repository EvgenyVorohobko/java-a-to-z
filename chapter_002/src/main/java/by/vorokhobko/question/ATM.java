package by.vorokhobko.question;

import java.util.ArrayList;

/**
 * ATM.
 *
 * Class ATM class for get change 002, lesson test.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.11.2017.
 * @version 1.
 */
public class ATM {
    /**
     * The class field.
     */
    private static final int CENT_1  = 1;
    /**
     * The class field.
     */
    private static final int CENT_2  = 2;
    /**
     * The class field.
     */
    private static final int CENT_5  = 5;
    /**
     * The class field.
     */
    private static final int CENT_10  = 10;
    /**
     * The class field.
     */
    private ArrayList<Integer> change = new ArrayList<>();
    /**
     * The method get users changes.
     * @param value - value.
     * @param price - price.
     * @return tag.
     * @throws NullException tag.
     */
    public ArrayList<Integer> changes(int value, int price) throws NullException {
        int result = value - price;
        if (result < 0) {
            throw new NullException("Could you put much money, please?");
        }
        if (result / CENT_10 > 0) {
            int last = lastNumber(result, CENT_10);
            if (CENT_5 > last) {
                int set = lastNumber(last, CENT_2);
                if (CENT_2 > set) {
                    if (CENT_1 == set) {
                        change.add(CENT_1);
                    }
                } else {
                    int stop = lastNumber(set, CENT_2);
                    if (CENT_1 == stop) {
                        change.add(CENT_1);
                    }
                }
            } else {
                int cost = lastNumber(last, CENT_5);
                if (CENT_2 < cost) {
                    int lastIndex = lastNumber(cost, CENT_2);
                    if (CENT_1 == lastIndex) {
                        change.add(CENT_1);
                    }
                } else {
                    if (CENT_1 == cost) {
                        change.add(CENT_1);
                    }
                }
            }
        }
        return this.change;
    }
    /**
     * The method helps the method change.
     * @param result - result.
     * @param element - element.
     * @return tag.
     */
    private int lastNumber(int result, int element) {
        int count = result / element;
        int start = element * count;
        result -= start;
        while (start != 0) {
            start -= element;
            change.add(element);
        }
        return result;
    }
}