package by.vorokhobko.servletwithuser;

import java.sql.Timestamp;

/**
 * User.
 *
 * Class User to create a user with different descriptions part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2018.
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
     * The class field.
     */
    private String password;
    /**
     * The class field.
     */
    private String role;
    /**
     * The class field.
     */
    private String country;
    /**
     * The class field.
     */
    private String town;
    /**
     * Add constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - createDate.
     * @param password - password.
     * @param role - role.
     */
    public User(String name, String login, String email, Timestamp createDate, String password, String role, String country, String town) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
        this.country = country;
        this.town = town;
    }
    /**
     * Add getter password.
     * @return tag.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Add getter role.
     * @return tag.
     */
    public String getRole() {
        return role;
    }
    /**
     * Add getter id.
     * @return tag.
     */
    public int getId() {
        return id;
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
     * Add getter createDate.
     * @return tag.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
    /**
     * Add getter country.
     * @return tag.
     */
    public String getCountry() {
        return country;
    }
    /**
     * Add getter town.
     * @return tag.
     */
    public String getTown() {
        return town;
    }
    /**
     * Add override method toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", createDate=" + createDate
                + ", id=" + id
                + ", password='" + password + '\''
                + ", role='" + role + '\''
                + ", country='" + country + '\''
                + ", town='" + town + '\''
                + '}';
    }
}