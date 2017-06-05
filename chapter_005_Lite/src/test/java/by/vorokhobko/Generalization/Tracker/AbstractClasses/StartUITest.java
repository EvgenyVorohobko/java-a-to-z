package by.vorokhobko.Generalization.Tracker.AbstractClasses;

import by.vorokhobko.Generalization.Tracker.Encapsulation.models.Item;
import by.vorokhobko.Generalization.Tracker.Encapsulation.start.Tracker;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 19.04.2017.
 */
 public class StartUITest {
    /**
     * Test Add.
     */
    @Test
    public void whenAddItemsWithMenuTracker() {
		Tracker tracker = new Tracker();
        Input inputAdd  = new StubInput(new String[]{"0", "testName", "testDesc", "45", "y"});
        new StartUI(inputAdd).init(tracker);
        assertThat(tracker.findAll().get(0).getName(), is("testName"));
	}
    /**
     * Test Show.
     */
    @Test
    public void whenShowItemsWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 1;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        Input inputUpdate = new StubInput(new String[]{String.valueOf(key), name1, desc1, time1, select});
        new StartUI(inputUpdate).init(tracker);
        Input input = new StubInput(new String[]{String.valueOf(keyMaster), select});
        new StartUI(input).init(tracker);
        List<Item> list = tracker.findAll();
        assertThat(list.get(0).getName(), is("testName"));
        assertThat(list.get(1).getName(), is("updateName"));
    }
    /**
     * Test Show Null.
     */
    @Test
    public void whenShowNullItemsWithMenuTracker() {
        Tracker tracker = new Tracker();
        int keyMaster = 1;
        String select = "y";
        Item item = new Item();
        Input input = new StubInput(new String[]{String.valueOf(keyMaster), select});
        new StartUI(input).init(tracker);
        Assert.assertNull(item.getName());
    }
    /**
     * Test Edit.
     */
    @Test
    public void whenEditItemsWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 2;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        List<Item> list = tracker.findAll();
        String id = list.get(0).getId();
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        Input inputUpdate = new StubInput(new String[]{String.valueOf(keyMaster), id, name1, desc1, time1, select});
        new StartUI(inputUpdate).init(tracker);
        assertThat(list.get(0).getName(), is("updateName"));
    }
    /**
     * Test Edit Null.
     */
    @Test
    public void whenEditNullItemsWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 2;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        String id = null;
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        Input inputUpdate = new StubInput(new String[]{String.valueOf(keyMaster), id, name1, desc1, time1, select});
        new StartUI(inputUpdate).init(tracker);
        List<Item> list = tracker.findAll();
        assertThat(list.get(0).getName(), is("testName"));
    }
    /**
     * Test Delete.
     */
    @Test
    public void whenUserDeleteWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 3;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        Input inputUpdate = new StubInput(new String[]{String.valueOf(key), name1, desc1, time1, select});
        new StartUI(inputUpdate).init(tracker);
        List<Item> list = tracker.findAll();
        String id = list.get(0).getId();
        Input inputDelete = new StubInput(new String[]{String.valueOf(keyMaster), id, select});
        new StartUI(inputDelete).init(tracker);
        Assert.assertNull(tracker.findById(id));
    }
    /**
     * Test Delete null.
     */
    @Test
    public void whenUserDeleteNullWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 3;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        String name1 = "updateName";
        String desc1 = "updateDesc";
        String time1 = "60";
        Input inputUpdate = new StubInput(new String[]{String.valueOf(key), name1, desc1, time1, select});
        new StartUI(inputUpdate).init(tracker);
        String id = null;
        Input inputDelete = new StubInput(new String[]{String.valueOf(keyMaster), id, select});
        new StartUI(inputDelete).init(tracker);
        Assert.assertNull(tracker.findById(id));
    }
    /**
     * Test Find by NAME.
     */
    @Test
    public void whenUserFindItemByNameWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 4;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        Input inputName = new StubInput(new String[]{String.valueOf(keyMaster), name, select});
        new StartUI(inputName).init(tracker);
        List<Item> list = tracker.findAll();
        assertThat(list.get(0).getName(), is("testName"));
    }
    /**
     * Test Find by NAME null.
     */
    @Test
    public void whenUserFindItemByNameNullWithMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 4;
        String select = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select});
        new StartUI(inputAdd).init(tracker);
        String nameTest = "ee";
        Input inputName = new StubInput(new String[]{String.valueOf(keyMaster), nameTest, select});
        new StartUI(inputName).init(tracker);
        List<Item> list = tracker.findAll();
        assertThat(list.get(0).getName(), is("testName"));
    }
    /**
     * Test Find by NAME null.
     */
    @Test
    public void whenUserDoNotCloseMenuTracker() {
        Tracker tracker = new Tracker();
        int key = 0;
        int keyMaster = 1;
        String select = "n";
        String exit = "y";
        String name = "testName";
        String desc = "testDesc";
        String time = "45";
        Input inputAdd = new StubInput(new String[]{String.valueOf(key), name, desc, time, select, String.valueOf(keyMaster), exit});
        new StartUI(inputAdd).init(tracker);
        List<Item> list = tracker.findAll();
        Assert.assertNotNull(list.get(0).getId());
    }
    /**
     * Test by Exception(StubInputTest).
     * @throws MenuOutException tag.
     */
    @Test(expected = MenuOutException.class)
    public void testException() throws MenuOutException {
        Tracker tracker = new Tracker();
        int keyMaster = 11;
        Input input = new StubInput(new String[]{String.valueOf(keyMaster)});
        new StartUI(input).init(tracker);
    }
 }