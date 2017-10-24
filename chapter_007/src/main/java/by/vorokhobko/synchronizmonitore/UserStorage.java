package by.vorokhobko.synchronizmonitore;

import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

/**
 * UserStorage.
 *
 * Class UserStorage a data structure for storing user part 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 30.08.2017.
 * @version 1.
 */
@ThreadSafe
public class UserStorage {
    /**
     * The class field.
     */
    private List<User> storage = new ArrayList<>();
    /**
     * The method adds a user to the UserStorage.
     * @param user - user.
     */
    public synchronized void add(User user) {
        this.storage.add(user);
    }
    /**
     * The method needs to replace the user in the UserStorage.
     * @param userUpdate - userUpdate.
     */
    public synchronized void update(User userUpdate) {
        for (int index = 0; index < this.storage.size(); index++) {
            if (this.storage.get(index).getId() == userUpdate.getId()) {
                this.storage.set(index, userUpdate);
                break;
            }
        }
    }
    /**
     * The method should delete the user in the UserStorage.
     * @param userDelete - userDelete.
     */
    public synchronized void delete(User userDelete) {
        for (int index = 0; index < this.storage.size(); index++) {
            if (this.storage.get(index).getId() == userDelete.getId()) {
                this.storage.remove(index);
                break;
            }
        }
    }
    /**
     * The method should transfer to this user's account UserStorage.
     * @param fromId - fromId.
     * @param toId - toId.
     * @param amount - amount.
     */
    public synchronized void transfer(int fromId, int toId, int amount) {
        try {
            if (storage.get(toId).getId() == toId) {
                this.storage.get(fromId).setAmount(storage.get(fromId).getAmount() - amount);
                this.storage.get(toId).setAmount(storage.get(toId).getAmount() + amount);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("This element don't have in storage.");
        }
    }
    /**
     * The method searches all Users.
     * @return tag.
     */
    public synchronized List<User> findAll() {
        return this.storage;
    }
    /**
     * The method searches element in storage.
     * @param id - id.
     * @return tag.
     */
    public synchronized User getStorage(int id) {
        return storage.get(id);
    }
}