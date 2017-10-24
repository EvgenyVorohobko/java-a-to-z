package by.vorokhobko.generalization;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 04.06.2017.
 */
public class UserConvertTest {
    /**
     * Test.
     */
    @Test
    public void whenListConvertToMap() {
        User user1 = new User(123, "Arseny", "Moscow");
        User user2 = new User(456, "Nick", "Minsk");
        User user3 = new User(789, "Jack", "Riga");
        UserConvert user = new UserConvert();
        List<User> list = new ArrayList<>(Arrays.asList(user1, user2, user3));
        HashMap<Integer, User> map = new HashMap<>();
        HashMap<Integer, User> result = user.process(list);
        map.put(user1.getId(), user1);
        map.put(user2.getId(), user2);
        map.put(user3.getId(), user3);
        assertThat(map, is(result));
    }
}