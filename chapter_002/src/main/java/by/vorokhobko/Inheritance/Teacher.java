package by.vorokhobko.Inheritance;

/**
 * Teacher.
 *
 * Class Teacher child class that inherits from Profession part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2017.
 * @version 1.
 */
public class Teacher extends Profession {
    /**
     * The class field.
     * Class inheritance Profession and the creation of an original metodov and fields.
     * Сreating refresher training.
     */
    private int refTrain;
	 /**
	 * Class Teacher.
	 * @param name - name.
	 * @param age - age.
	 * @param university - university.
	 * @param recommendations - recommendations.
	 * @param aScore - aScore.
	 */
    public Teacher(String name, int age, String university, String recommendations, int aScore) {
        super(name, age, university, recommendations, aScore);
        this.refTrain = refTrain;
    }
}