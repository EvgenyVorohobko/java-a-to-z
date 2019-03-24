package by.vorokhobko.models;

import javax.persistence.*;

/**
 * Owner.
 *
 * Class Owner create element in area car sales part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
@Entity
@Table(name = "owner")
public class Owner {
    /**
     * The class field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * The class field.
     */
    @Column(name = "name")
    private String name;
    /**
     * The class field.
     */
    @Column(name = "login")
    private String login;
    /**
     * The class field.
     */
    @Column(name = "email")
    private String email;
    /**
     * The class field.
     */
    @Column(name = "password")
    private String password;
    /**
     * The class field.
     */
    @Column(name = "phone")
    private String phone;
    /**
     * Add constructor.
     */
    public Owner() {}
    /**
     * Add getter.
     * @return tag.
     */
    public int getId() {
        return id;
    }
    /**
     * Add setter.
     * @param id - id.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getName() {
        return name;
    }
    /**
     * Add setter.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Add setter.
     * @param login - login.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Add setter.
     * @param email - email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Add setter.
     * @param password - password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Add getter.
     * @return tag.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Add setter.
     * @param phone - phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
