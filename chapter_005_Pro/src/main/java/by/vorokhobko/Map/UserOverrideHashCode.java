package by.vorokhobko.Map;

import java.util.Calendar;

/**
 * UserOverrideHashCode.
 *
 * Class UserOverrideHashCode for Map, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.07.2017.
 * @version 1.
 */
public class UserOverrideHashCode extends User {
    /**
     * Add constructor.
     * @param name - name.
     * @param children - children.
     * @param birthday - birthday.
     */
    public UserOverrideHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
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