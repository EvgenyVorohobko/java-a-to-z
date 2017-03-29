package by.vorokhobko.Polymorphism;

import by.vorokhobko.Encapsulation.start.Tracker;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.02.2017.
 */

public class StubInputTest {
    /**
     * Test.
     */
    @Test
    public void whenUserAddItem() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
		String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is("testName"));
    }
}