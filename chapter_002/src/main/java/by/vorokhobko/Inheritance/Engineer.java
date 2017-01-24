package by.vorokhobko.Inheritance;

/**
 * Engineer.
 *
 * Class Engineer child class that inherits from Profession part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2017.
 * @version 1.
 */
public class Engineer extends Profession {
    /**
     * The class field.
     * Class inheritance Profession and the creation of an original metodov and fields.
     * Сreating experience.
     */
    private int experience;
    public Engineer(String name, int age, String university, String recommendations, int aScore) {
        super(name, age, university, recommendations, aScore);
        this.experience = experience;
    }
}