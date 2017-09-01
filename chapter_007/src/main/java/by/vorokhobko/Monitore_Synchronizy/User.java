package by.vorokhobko.Monitore_Synchronizy;

/**
 * User.
 *
 * Class User for constructor UserStorage 007, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 30.08.2017.
 * @version 1.
 */
public class User {
    /**
     * The class field.
     */
    private int amount;
    /**
     * The class field.
     */
    private int id;
    /**
     * Add constructor.
     * @param id - id.
     * @param amount - amount.
     */
    public User(int id, int amount) {
        this.amount = amount;
        this.id = id;
    }
    /**
     * Add getter amount.
     * @return tag.
     */
    public int getAmount() {
        return amount;
    }
    /**
     * Add getter id.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add setter amount.
     * @param amount - amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}