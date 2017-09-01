package by.vorokhobko.Monitore_Synchronizy;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 31.08.2017.
 */
public class UserStorageTest {
    /**
     * The class field.
     */
    private User user1 = new User(0, 100);
    /**
     * The class field.
     */
    private User user2 = new User(1, 200);
    /**
     * The class field.
     */
    private UserStorage storage = new UserStorage();
    /**
     * The class field.
     */
    private List<User> list = new ArrayList<>();
    /**
     * Test.
     */
    @Test
    public void whenAddElementInList() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        this.list.add(this.user1);
        this.list.add(this.user2);
        assertThat(this.storage.findAll(), is(this.list));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateElementInList() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        User user3 = new User(1, 500);
        storage.update(user3);
        assertThat(user3.getAmount(), is(storage.getStorage(1).getAmount()));
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteElementInList() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        this.storage.delete(user1);
        this.list.add(this.user2);
        assertThat(this.storage.findAll(), is(this.list));
    }
    /**
     * Test.
     */
    @Test
    public void whenTransferElementsInStorage() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        this.storage.transfer(0, 1, 50);
        int resultUser1 = 50;
        int resultUser2 = 250;
        assertThat(this.storage.getStorage(0).getAmount(), is(resultUser1));
        assertThat(this.storage.getStorage(1).getAmount(), is(resultUser2));
    }
    /**
     * Test.
     */
    @Test
    public void whenDoNotTransferFromElementsInStorage() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        this.storage.transfer(0, 8, 50);
        assertThat(this.storage.getStorage(0).getAmount(), is(100));
        assertThat(this.storage.getStorage(1).getAmount(), is(200));
    }
    /**
     * Test.
     */
    @Test
    public void whenDoNotTransferToElementsInStorage() {
        this.storage.add(this.user1);
        this.storage.add(this.user2);
        this.storage.transfer(5, 1, 50);
        assertThat(this.storage.getStorage(0).getAmount(), is(100));
        assertThat(this.storage.getStorage(1).getAmount(), is(200));
    }
}