package by.vorokhobko.sorting;

/**
 * User.
 *
 * Class User sorting User 005_Lite, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 07.06.2017.
 * @version 1.
 */
public class User implements Comparable<User> {
    /**
     * The class field.
     */
    private String name;
    /**
     * The class field.
     */
    private int age;
    /**
     * Override method compareTo.
     * @param user - user.
     * @return tag.
     */
    @Override
    public int compareTo(User user) {
        int result = 0;
        if (this.age < user.age) {
            result = -1;
        } else if (this.age > user.age) {
            result = 1;
        } else if (this.age == user.age) {
            result = 0;
        }
        return result;
    }
    /**
     * Add constructor.
     * @param age - age.
     * @param name - name.
     */
    public User(String name, int age) {
        this.age = age;
        this.name = name;
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
        return age == user.age;

    }
    /**
     * Override method hashCode.
     * @return tag.
     */
    @Override
    public int hashCode() {
        return age;
    }
    /**
     * Add getter name.
     * @return tag.
     */
    public String getName() {
        return name;
    }
    /**
     * Add getter age.
     * @return tag.
     */
    public int getAge() {
        return age;
    }
}