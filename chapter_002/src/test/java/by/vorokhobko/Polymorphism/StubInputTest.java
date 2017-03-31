package by.vorokhobko.Polymorphism;

import by.vorokhobko.Encapsulation.start.Tracker;
import org.junit.Assert;
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
     * Test add.
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
    /**
     * Test show.
     */
    @Test
    public void whenUserShowItem() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        String exit1 = "7";
        Input inputUpdate = new StubInput(new String[]{"2", name1, desc1, time1, exit1});
        new StartUI(inputUpdate).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is(name));
        assertThat(tracker.findAll()[1].getName(), is(name1));
    }
    /**
     * Test Edit.
     */
    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = tracker.findAll()[0].getId();
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        String exit1 = "7";
        Input inputUpdate = new StubInput(new String[]{"3", id, name1, desc1, time1, exit1});
        new StartUI(inputUpdate).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is(name1));
    }
    /**
     * Test edit item NULL.
     */
    @Test
    public void whenUserEditItemNull() {
        Tracker tracker = new Tracker();
        String name1 = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name1, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = "null";
        String name2 = "updateName";
        String desc2 = "updateDesc";
        String time2 = "60";
        Input inputEdit = new StubInput(new String[]{id, name2, desc2, time2, exit});
        new StartUI(inputEdit).editItem(tracker);
        assertThat(tracker.findAll()[0].getName(), is("testName"));
    }
    /**
     * Test delete item.
     */
    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();
        String name1 = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input0 = new StubInput(new String[]{"1", name1, desc, time, exit});
        new StartUI(input0).init(tracker);
        String name2 = "newName";
        String desc2 = "newDesc";
        String time2 = "60";
        Input input1 = new StubInput(new String[]{"1", name2, desc2, time2, exit});
        new StartUI(input1).init(tracker);
        String id = tracker.findAll()[0].getId();
        Input inputDelete = new StubInput(new String[]{"4", id});
        new StartUI(inputDelete).init(tracker);
        Assert.assertNull(tracker.findById(id));
    }
    /**
     * Test delete item NULL.
     */
    @Test
    public void whenUserDeleteItemNull() {
        Tracker tracker = new Tracker();
        String name1 = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input0 = new StubInput(new String[]{"1", name1, desc, time, exit});
        new StartUI(input0).init(tracker);
        String name2 = "newName";
        String desc2 = "newDesc";
        String time2 = "60";
        Input input1 = new StubInput(new String[]{"1", name2, desc2, time2, exit});
        new StartUI(input1).init(tracker);
        String id = "null";
        Input inputDelete = new StubInput(new String[]{"4", id});
        new StartUI(inputDelete).init(tracker);
        Assert.assertNull(tracker.findById(id));
    }
    /**
     * Test find by ID.
     */
    @Test
    public void whenUserFindItemById() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = tracker.findAll()[0].getId();
        Input inputId = new StubInput(new String[]{"5", id});
        new StartUI(inputId).init(tracker);
        assertThat(tracker.findAll()[0].getId(), is(id));
    }
    /**
     * Test find by ID NULL.
     */
    @Test
    public void whenUserFindItemByIdNull() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = "null";
        Input inputId = new StubInput(new String[]{"5", id});
        new StartUI(inputId).init(tracker);
        Assert.assertNull(tracker.findById(id));
    }
    /**
     * Test find by NAME.
     */
    @Test
    public void whenUserFindItemByName() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = tracker.findAll()[0].getId();
        Input inputId = new StubInput(new String[]{"6", id});
        new StartUI(inputId).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is(name));
    }
    /**
     * Test find by NAME NULL.
     */
    @Test
    public void whenUserFindItemByNameNull() {
        Tracker tracker = new Tracker();
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        String exit = "7";
        Input input = new StubInput(new String[]{"1", name, desc, time, exit});
        new StartUI(input).init(tracker);
        String id = "null";
        Input inputId = new StubInput(new String[]{"6", id});
        new StartUI(inputId).init(tracker);
        assertThat(tracker.findAll()[0].getName(), is(name));
    }
}