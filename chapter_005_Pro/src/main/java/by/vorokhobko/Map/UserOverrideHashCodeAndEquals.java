package by.vorokhobko.map;

import java.util.Calendar;

/**
 * UserOverrideHashCodeAndEquals.
 *
 * Class UserOverrideHashCodeAndEquals for map, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.07.2017.
 * @version 1.
 */
public class UserOverrideHashCodeAndEquals extends User {
    /**
     * Add constructor.
     * @param name - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public UserOverrideHashCodeAndEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
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
        UserOverrideHashCodeAndEquals that = (UserOverrideHashCodeAndEquals) o;
        if (getChildren() != that.getChildren()) {
            return false;
        }
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
            return false;
        }
        return !(getBirthday() != null ? !getBirthday().equals(that.getBirthday()) : that.getBirthday() != null);
    }
    /**
     * Override method hashCode.
     * @return tag.
     */
    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getChildren();
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }
}