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
    private Role role;
    /**
     * Add constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - createDate.
     * @param password - password.
     * @param role - role.
     */
    public User(String name, String login, String email, Timestamp createDate, String password, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
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
    public Role getRole() {
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
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (createDate != null ? !createDate.equals(user.createDate) : user.createDate != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return !(role != null ? !role.equals(user.role) : user.role != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}