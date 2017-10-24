package by.vorokhobko.generalization;

/**
 * User.
 *
 * Class User for work 005_Lite, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 04.06.2017.
 * @version 1.
 */
public class User {
    /**
     * The class field.
     */
    private int id;
    /**
     * The class field.
     */
    private String name;
    /**
     * The class field.
     */
    private String city;
    /**
     * Add getter id.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add constructor.
     * @param id - id.
     * @param name - name.
     * @param city - city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}