package by.vorokhobko.sorting;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 07.06.2017.
 */
public class SortUserTest {
    /**
     * Test.
     */
    @Test
    public void whenArrayConvertToList() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Mixail", 15),
                new User("Evpatiy", 40),
                new User("Anton", 53),
                new User("Xander", 10)));
        Set<User> set = user.sortListToSet(list);
        Set<User> result = new TreeSet<>(Arrays.asList(
                new User("Xander", 10),
                new User("Mixail", 15),
                new User("Evpatiy", 40),
                new User("Anton", 53)));
        assertThat(set, is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenArrayConvertToSortNameLength() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Evlampiys", 15),
                new User("Nik", 40),
                new User("Anton", 53),
                new User("Vladlen", 10)));
        List<User> set = user.sortNameLength(list);
        List<User> result = new ArrayList<>(Arrays.asList(
                new User("Nik", 40),
                new User("Anton", 53),
                new User("Vladlen", 10),
                new User("Evlampiys", 15)));
        assertThat(set, is(result));
    }
    /**
     * Test.
     */
    @Test
    public void whenArraySortToNameAndAge() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Mixail", 15),
                new User("Anton", 40),
                new User("Anton", 53),
                new User("Mixail", 10)));
        List<User> set = user.sortByAllFields(list);
        List<User> result = new ArrayList<>(Arrays.asList(
                new User("Anton", 40),
                new User("Anton", 53),
                new User("Mixail", 10),
                new User("Mixail", 15)));
        assertThat(set, is(result));
    }
}