package by.vorokhobko.Exception;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
//import org.junit.Assert;
import by.vorokhobko.Encapsulation.start.Tracker;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.04.2017.
 */

 public class MenuTrackerTestException {
    /**
     * Test Add.
     */
    @Test
    public void whenAddItemsWithMenuTracker() {
		Tracker tracker = new Tracker();
        int key = 0;
        String exit = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd  = new StubInput(new String[]{String.valueOf(key), name, desc, time, exit});
        new StartUI(inputAdd).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is("testName"));
	}
 }