package by.vorokhobko.Map;

import java.util.Calendar;

/**
 * UserOverrideEquals.
 *
 * Class UserOverrideEquals for Map, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.07.2017.
 * @version 1.
 */
public class UserOverrideEquals extends User {
    /**
     * Add constructor.
     * @param name - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public UserOverrideEquals(String name, int children, Calendar birthday) {
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
        UserOverrideEquals that = (UserOverrideEquals) o;
        if (getChildren() != that.getChildren()) {
            return false;
        }
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
            return false;
        }
        return !(getBirthday() != null ? !getBirthday().equals(that.getBirthday()) : that.getBirthday() != null);
    }
}