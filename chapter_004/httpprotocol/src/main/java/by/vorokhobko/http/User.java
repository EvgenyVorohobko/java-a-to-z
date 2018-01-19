package by.vorokhobko.http;

import java.sql.Timestamp;

/**
 * User.
 *
 * Class User to create a user with different descriptions part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.01.2018.
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
    private String login;
    /**
     * The class field.
     */
    private String email;
    /**
     * The class field.
     */
    private Timestamp createDate;
    /**
     * The class field.
     */
    private int id;
    /**
     * Add constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - createDate.
     */
    public User(String name, String login, String email, Timestamp createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }
    /**
     * Add setter setId.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Add getter name.
     * @return tag.
     */
    public String getName() {
        return name;
    }
    /**
     * Add getter login.
     * @return tag.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Add getter email.
     * @return tag.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Add override method toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}