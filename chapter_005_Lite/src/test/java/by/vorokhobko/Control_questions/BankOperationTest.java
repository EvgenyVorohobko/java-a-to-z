package by.vorokhobko.Control_questions;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 12.06.2017.
 */
public class BankOperationTest {
    /**
     * The class field.
     */
    private BankOperation bo = new BankOperation();
    /**
     * Test.
     */
    @Test
    public void whenAddUserForBank() {
        bo.addUser(new User("Stiven", 198435));
        bo.addUser(new User("Mixail", 195320));
        int count = bo.getRequisites();
        assertThat(2, is(count));
    }
    /**
     * Test.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenDeleteUserForBank() throws DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        User user2 = new User("Mixail", 195320);
        bo.addUser(user1);
        bo.addUser(user2);
        bo.deleteUser(user2);
        int count = bo.getRequisites();
        assertThat(1, is(count));
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenAddAccountUserForBank() throws DoNotAccountForMap, DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        Account account1 = new Account(12345, 23345343.0);
        Account account2 = new Account(12675, 23345.0);
        List<Account> list = new ArrayList<>(Arrays.asList(account1, account2));
        bo.addUser(user1);
        bo.addAccountToUser(user1, account1);
        bo.addAccountToUser(user1, account2);
        List<Account> result = bo.getUserAccounts(user1);
        assertThat(list, is(result));
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenDeleteAccountUserForBank() throws DoNotAccountForMap, DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        Account account1 = new Account(12345, 23345343.0);
        Account account2 = new Account(45346, 56456.0);
        List<Account> list = new ArrayList<>(Arrays.asList(account1));
        bo.addUser(user1);
        bo.addAccountToUser(user1, account1);
        bo.addAccountToUser(user1, account2);
        bo.deleteAccountFromUser(user1, account2);
        List<Account> result = bo.getUserAccounts(user1);
        assertThat(list, is(result));
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenGetAllUserAccount() throws DoNotUserForMap, DoNotAccountForMap {
        User user1 = new User("Stiven", 198435);
        Account account1 = new Account(12345, 23345343.0);
        Account account2 = new Account(45346, 56456.0);
        bo.addUser(user1);
        bo.addAccountToUser(user1, account1);
        bo.addAccountToUser(user1, account2);
        List<Account> list = new ArrayList<>(Arrays.asList(account1, account2));
        assertThat(list, is(bo.getUserAccounts(user1)));
    }
    /**
     * Test by Exception.
     * @throws DoNotUserForMap tag.
     */
    @Test(expected = DoNotUserForMap.class)
    public void whenDeleteUserForBankButUserDoNotForMap() throws DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        User user2 = new User("Mixail", 195320);
        bo.addUser(user1);
        bo.deleteUser(user2);
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test(expected = DoNotAccountForMap.class)
    public void whenDeleteAccountUserForBankButAccountDoNotForUser() throws DoNotAccountForMap, DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        Account account1 = new Account(12345, 23345343.0);
        Account account2 = new Account(45346, 56456.0);
        bo.addUser(user1);
        bo.addAccountToUser(user1, account1);
        bo.deleteAccountFromUser(user1, account2);
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenTransferMoneyFromOneAccountToAnother() throws DoNotAccountForMap, DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        User user2 = new User("Mixail", 195320);
        bo.addUser(user1);
        bo.addUser(user2);
        Account account1 = new Account(12345, 100.0);
        Account account2 = new Account(45346, 50.0);
        bo.addAccountToUser(user1, account1);
        bo.addAccountToUser(user2, account2);
        assertThat(true, is(bo.transferMoney(user1, account1, user2, account2, 50.0)));
        assertThat(50.0, is(bo.allAccounts().get(user1).get(0).getValue()));
        assertThat(100.0, is(bo.allAccounts().get(user2).get(0).getValue()));
    }
    /**
     * Test.
     * @throws DoNotAccountForMap tag.
     * @throws DoNotUserForMap tag.
     */
    @Test
    public void whenTransferMoneyFromOneAccountToAnotherButNotMoney() throws DoNotAccountForMap, DoNotUserForMap {
        User user1 = new User("Stiven", 198435);
        User user2 = new User("Mixail", 195320);
        bo.addUser(user1);
        bo.addUser(user2);
        Account account1 = new Account(12345, 100.0);
        Account account2 = new Account(45346, 50.0);
        bo.addAccountToUser(user1, account1);
        bo.addAccountToUser(user2, account2);
        bo.transferMoney(user1, account1, user2, account2, 200.0);
        assertThat(bo.transferMoney(user1, account1, user2, account2, 200.0), is(false));
    }
}