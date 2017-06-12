package by.vorokhobko.Control_questions;

/**
 * User.
 *
 * Class User for control questions 005_Lite, lesson 4.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 09.06.2017.
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
    private int passport;
    /**
     * Add constructor.
     * @param passport - passport.
     * @param name - name.
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Override method equals.
     * @param o - o.
     * @return tag.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (passport != user.passport) {
            return false;
        }
        return !(name != null ? !name.equals(user.name) : user.name != null);
    }
    /**
     * Override method hashCode.
     * @return tag.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + passport;
        return result;
    }
}