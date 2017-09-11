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
}