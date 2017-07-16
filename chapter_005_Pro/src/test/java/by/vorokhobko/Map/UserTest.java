package by.vorokhobko.Map;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 14.07.2017.
 */
public class UserTest {
    /**
     * Test.
     */
    @Test
    public void whenAddUserInMap() {
        User userFirst = new User("Tony", 2, new GregorianCalendar(1990, 6, 13));
        User userSecond = new User("Tony", 2, new GregorianCalendar(1990, 6, 13));
        Map<User, Object> mapFirst = new HashMap<>();
        mapFirst.put(userFirst, "Stark");
        mapFirst.put(userSecond, "Kark");
        assertThat(mapFirst.size(), is(2));
        System.out.println(mapFirst);
        System.out.println(userFirst.hashCode());
        System.out.println(userSecond.hashCode());
    }
    /**
     * Test.
     */
    @Test
    public void whenAddUserOverrideHashCodeInMap() {
        UserOverrideHashCode userFirst = new UserOverrideHashCode("Skott", 2, new GregorianCalendar(1990, 6, 13));
        UserOverrideHashCode userSecond = new UserOverrideHashCode("Skott", 2, new GregorianCalendar(1990, 6, 13));
        Map<UserOverrideHashCode, Object> mapSecond = new HashMap<>();
        mapSecond.put(userFirst, "Stark");
        mapSecond.put(userSecond, "Kark");
        assertThat(mapSecond.size(), is(2));
        System.out.println(mapSecond);
        System.out.println(userFirst.hashCode());
        System.out.println(userSecond.hashCode());
    }
    /**
     * Test.
     */
    @Test
    public void whenAddUserOverrideEqualsInMap() {
        UserOverrideEquals userFirst = new UserOverrideEquals("Skott", 2, new GregorianCalendar(1990, 6, 13));
        UserOverrideEquals userSecond = new UserOverrideEquals("Skott", 2, new GregorianCalendar(1990, 6, 13));
        Map<UserOverrideEquals, Object> mapThird = new HashMap<>();
        mapThird.put(userFirst, "Stark");
        mapThird.put(userSecond, "Kark");
        assertThat(mapThird.size(), is(2));
        System.out.println(mapThird);
        System.out.println(userFirst.hashCode());
        System.out.println(userSecond.hashCode());
    }
    /**
     * Test.
     */
    @Test
    public void whenAddUserOverrideHashCodeAndEqualsInMap() {
        UserOverrideHashCodeAndEquals userFirst = new UserOverrideHashCodeAndEquals("Skott", 2, new GregorianCalendar(1990, 6, 13));
        UserOverrideHashCodeAndEquals userSecond = new UserOverrideHashCodeAndEquals("Skott", 2, new GregorianCalendar(1990, 6, 13));
        Map<UserOverrideHashCodeAndEquals, Object> mapFourth = new HashMap<>();
        mapFourth.put(userFirst, "Stark");
        mapFourth.put(userSecond, "Kark");
        assertThat(mapFourth.size(), is(1));
        System.out.println(mapFourth);
        System.out.println(userFirst.hashCode());
        System.out.println(userSecond.hashCode());
    }
}