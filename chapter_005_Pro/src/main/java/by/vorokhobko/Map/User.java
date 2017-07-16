package by.vorokhobko.Map;

import java.util.Calendar;

/**
 * User.
 *
 * Class User for Map, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.07.2017.
 * @version 1.
 */
public class User {
    /**
     * The class field.
     */
    private String name;
    /**
     * The class field.
     */
    private int children;
    /**
     * The class field.
     */
    private Calendar birthday;
    /**
     * Add constructor.
     * @param name - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    /**
     * Add getter birthday.
     * @return tag.
     */
    public Calendar getBirthday() {
        return birthday;
    }
    /**
     * Add getter children.
     * @return tag.
     */
    public int getChildren() {
        return children;
    }
    /**
     * Add getter name.
     * @return tag.
     */
    public String getName() {
        return name;
    }
}