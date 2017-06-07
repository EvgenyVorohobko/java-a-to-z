package by.vorokhobko.Sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser.
 *
 * Class SortUser converts List to Set 005_Lite, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.06.2017.
 * @version 1.
 */
public class SortUser {
    /**
     * The method add sort element to Set.
     * @param list - list.
     * @return tag.
     */
    public Set<User> sortListToSet(List<User> list) {
        Set<User> set = new TreeSet<>();
        for (User user : list) {
            set.add(user);
        }
        return set;
    }
}