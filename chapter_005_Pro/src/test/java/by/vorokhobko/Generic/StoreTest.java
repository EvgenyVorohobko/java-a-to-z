package by.vorokhobko.Generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 21.06.2017.
 */
public class StoreTest {
    /**
     * Test.
     */
    @Test
    public void whenAddUserInStore() {
        Store store = new Store(10);
        User user = new User("test");
        store.add(user);
        assertThat(store.getSimple().get(0), is(user));
    }
    /**
     * Test.
     */
    @Test
    public void whenDeleteUserInStore() {
        Store store = new Store(10);
        Role role1 = new Role("test");
        Role role2 = new Role("Old test");
        store.add(role1);
        store.add(role2);
        store.remove(role2);
        assertThat(null, is(store.getSimple().get(1)));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateUserInStore() {
        Store store = new Store(10);
        User user1 = new User("test");
        User user2 = new User("Old test");
        user1.setId(user2.getId());
        store.add(user1);
        store.update(user2, 0);
        assertThat(store.getSimple().get(0), is(user2));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateUserInUserStore() {
        UserStore userStore = new UserStore(10);
        User user1 = new User("test");
        User user2 = new User("Old test");
        userStore.add(user1);
        userStore.update(user2, 0);
        assertThat(userStore.getSimple().get(0), is(user2));
    }
    /**
     * Test.
     */
    @Test
    public void whenUpdateRoleInRoleStore() {
        RoleStore roleStore = new RoleStore(10);
        Role role1 = new Role("test");
        Role role2 = new Role("Old test");
        roleStore.add(role1);
        roleStore.update(role2, 0);
        assertThat(roleStore.getSimple().get(0), is(role2));
    }
}