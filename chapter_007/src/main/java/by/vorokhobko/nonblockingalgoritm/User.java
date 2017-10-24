package by.vorokhobko.nonblockingalgoritm;

/**
 * User.
 *
 * Class User abstract class for date part 007, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 11.10.2017.
 * @version 1.
 */
public class User {
    /**
     * The class field.
     */
    private int key;
    /**
     * The class field.
     */
    private String value;
    /**
     * The class field.
     */
    private int version;
    /**
     * Add Item.
     * @param key - key.
     * @param value - value.
     */
    public User(int key, String value) {
        this.key = key;
        this.value = value;
    }
    /**
     * Add setter value.
     * @param value - value.
     */
    public void setValue(String value) {
        this.value = value;
        this.version++;
    }
    /**
     * Add getter key.
     * @return tag.
     */
    public int getKey() {
        return key;
    }
    /**
     * Add getter value.
     * @return tag.
     */
    public String getValue() {
        return value;
    }
    /**
     * Add getter version.
     * @return tag.
     */
    public int getVersion() {
        return version;
    }
    /**
     * Add override toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "User{" + "key=" + key + ", value='" + value + '\''
                + ", version=" + version + '}';
    }
}