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
    private static final int[] DATA = {10, 5, 2, 1};
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
        while (result > 0) {
            for (int coin : DATA) {
                if (result - coin >= 0) {
                    this.change.add(coin);
                    result -= coin;
                    break;
                }
            }
        }
        return this.change;
    }
}