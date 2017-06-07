package by.vorokhobko.Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

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
    /**
     * The method sort element to length name.
     * @param list - list.
     * @return tag.
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> result = new ArrayList<>();
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int count = user1.getName().length() > user2.getName().length() ? 1 : -1;
                return count;
            }
        });
        return result;
    }
    /**
     * The method sort element to name and age.
     * @param list - list.
     * @return tag.
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> result = new ArrayList<>();
        result.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int count = 0;
                if (count == user1.getName().compareTo(user2.getName())) {
                    count = user1.getAge() > user2.getAge() ? 1 : -1;
                }
                return count;
            }
        });
        return result;
    }
}