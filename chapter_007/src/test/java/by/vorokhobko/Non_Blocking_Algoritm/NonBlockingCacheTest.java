package by.vorokhobko.Non_Blocking_Algoritm;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 12.10.2017.
 */
public class NonBlockingCacheTest {
    /**
     * The class field.
     */
    private NonBlockingCache cache = new NonBlockingCache();
    /**
     * Test.
     */
    @Test
    public void whenAddElementInMap() {
        cache.add(new User(3, "Alex"));
        cache.add(new User(5, "Matcher"));
        cache.add(new User(7, "Stels"));
        assertThat(cache.size(), is(3));
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteElementInMap() {
        cache.add(new User(3, "Alex"));
        cache.add(new User(5, "Matcher"));
        cache.add(new User(7, "Stels"));
        cache.remove(3);
        assertThat(null, is(cache.get(3)));
    }
    /**
     * Test.
     */
    @Test
    public void whenNoDeleteElementInMap() {
        cache.add(new User(3, "Alex"));
        cache.add(new User(5, "Matcher"));
        cache.add(new User(7, "Stels"));
        cache.remove(2);
        assertThat(cache.size(), is(3));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateElementInTheMap() {
        User user = new User(7, "Matverk");
        cache.add(user);
        User user1 = new User(7, "Stels");
        cache.update(user1);
        assertThat(cache.get(7), is(user));
    }
}