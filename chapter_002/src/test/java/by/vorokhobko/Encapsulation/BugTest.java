package by.vorokhobko.encapsulation;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import by.vorokhobko.encapsulation.models.Bug;
import org.junit.Test;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.02.2017.
 */
public class BugTest {
    /**
     * Test.
     */
    @Test
    public void whenInItemHaveBug() {
        Bug bug = new Bug("testName", "testDesc", 5L);
        String name = "nameTest2";
        bug.setName(name);
        String result = bug.getName();
        assertThat(result, is(name));
    }
}
