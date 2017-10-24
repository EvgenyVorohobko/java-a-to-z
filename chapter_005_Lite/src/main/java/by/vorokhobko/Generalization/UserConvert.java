package by.vorokhobko.generalization;

import java.util.HashMap;
import java.util.List;

/**
 * UserConvert.
 *
 * Class UserConvert converts list to map 005_Lite, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.06.2017.
 * @version 1.
 */
public class UserConvert {
    /**
     * The method add element to array.
     * @param list - list.
     * @return tag.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}