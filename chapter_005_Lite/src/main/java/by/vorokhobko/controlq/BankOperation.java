package by.vorokhobko.controlq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BankOperation.
 *
 * Class BankOperation for control questions 005_Lite, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 09.06.2017.
 * @version 1.
 */
public class BankOperation {
    /**
     * The class field.
     */
    private Map<User, List<Account>> result = new HashMap<>();
    /**
     * The method adds a user to Map.
     * @param user - user.
     */
    public void addUser(User user) {
        this.result.put(user, new ArrayList<>());
    }
    /**
     * The method specifies the number of Requisites.
     * @return tag.
     */
    public int getRequisites() {
        return this.result.size();
    }
    /**
     * The method should delete Users in the List.
     * @param user - user.
     * @throws DoNotUserForMap tag.
     */
    public void deleteUser(User user) throws DoNotUserForMap {
        if (isThereUser(user)) {
            this.result.remove(user);
        }
    }
    /**
     * The method add User new account.
     * @param user - user.
     * @param account - account.
     * @throws DoNotUserForMap tag.
     * @throws DoNotAccountForMap tag.
     */
    public void addAccountToUser(User user, Account account) throws DoNotUserForMap, DoNotAccountForMap {
        if (isThereUser(user)) {
            this.result.get(user).add(account);
        }
    }
    /**
     * The method specifies the number of all accounts.
     * @return tag.
     */
    public Map<User, List<Account>> allAccounts() {
        return this.result;
    }
    /**
     * The method should delete the account in the User.
     * @param user - user.
     * @param account - account.
     * @throws DoNotUserForMap tag.
     * @throws DoNotAccountForMap tag.
     */
    public void deleteAccountFromUser(User user, Account account) throws DoNotUserForMap, DoNotAccountForMap {
        if (isThereUser(user)) {
            if (isThereAccount(user, account)) {
                this.result.get(user).remove(account);
            }
        }
    }
    /**
     * The method return all user accounts.
     * @param user - user.
     * @return tag.
     * @throws DoNotUserForMap tag.
     * @throws DoNotAccountForMap tag.
     */
    public List<Account> getUserAccounts(User user) throws DoNotUserForMap, DoNotAccountForMap {
        List<Account> list = new ArrayList<>();
        if (isThereUser(user)) {
            list = this.result.get(user);
        }
        return list;
    }
    /**
     * The method should delete the account in the User.
     * @param srcUser - srcUser.
     * @param srcAccount - srcAccount.
     * @param dstUser - dstUser.
     * @param dstAccount - dstAccount.
     * @param amount - amount.
     * @throws DoNotUserForMap tag.
     * @throws DoNotAccountForMap tag.
     * @return tag.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) throws DoNotUserForMap, DoNotAccountForMap {
        boolean isNeedSave = false;
        if (isThereAccount(srcUser, srcAccount)) {
            if (isThereAccount(dstUser, dstAccount)) {
                if (srcAccount.getValue() >= amount) {
                    double count = srcAccount.getValue() - amount;
                    srcAccount.setValue(count);
                    double result = dstAccount.getValue() + amount;
                    dstAccount.setValue(result);
                    isNeedSave = true;
                } else {
                    System.out.println("Your account has insufficient funds!");
                }
            }
        }
        return isNeedSave;
    }
    /**
     * The method determines whether User contain in Bank.
     * @param user - user.
     * @throws DoNotUserForMap tag.
     * @return tag.
     */
    public boolean isThereUser(User user) throws DoNotUserForMap {
        if (result.containsKey(user)) {
            return true;
        } else {
            throw new DoNotUserForMap("The user is not present in the program!");
        }
    }
    /**
     * The method determines whether account contain in User.
     * @param user - user.
     * @param account - account.
     * @throws DoNotUserForMap tag.
     * @throws DoNotAccountForMap tag.
     * @return tag.
     */
    public boolean isThereAccount(User user, Account account) throws DoNotUserForMap, DoNotAccountForMap {
        boolean count = false;
        if (isThereUser(user)) {
            if (result.get(user).contains(account)) {
                count = true;
            } else {
                throw new DoNotAccountForMap("The account is not present in the program!");
            }
        }
        return count;
    }
}