package by.vorokhobko.generalization.tracker.encapsulation;


import by.vorokhobko.generalization.tracker.encapsulation.models.Item;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 23.02.2017.
 */
public class ItemTest {
    /**
     * Test.
     */
    @Test
    public void whenItemReceivesNewName() {
        Item item = new Item("testName", "testDesc", 5L);
        String name = "nameTest2";
        item.setName(name);
        String result = item.getName();
        assertThat(result, is(name));
    }
    /**
     * Test.
     */
    @Test
    public void whenItemReceivesNewDescription() {
        Item item = new Item("testName", "testDesc", 5L);
        String desc = "descTest2";
        item.setDescription(desc);
        String result = item.getDescription();
        assertThat(result, is(desc));
    }
    /**
     * Test.
     */
    @Test
    public void whenItemReceivesNewCreate() {
        Item item = new Item("testName", "testDesc", 5L);
        long create = 7L;
        item.setCreate(create);
        long result = item.getCreate();
        assertThat(result, is(create));
    }
}
