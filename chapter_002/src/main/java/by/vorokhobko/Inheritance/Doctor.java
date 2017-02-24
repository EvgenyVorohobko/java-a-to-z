package by.vorokhobko.Inheritance;

/**
 * Doctor.
 *
 * Class Doctor child class that inherits from Profession part 002, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.01.2017.
 * @version 1.
 */
public class Doctor extends Profession {
    /**
     * The class field.
     * Class inheritance Profession and the creation of an original metodov and fields.
     * Сreating internship.
     */
    private int internship;
    /**
     * The class field.
	 * Сreating residency.
	 */
    private int residency;
	/**
	* Class Doctor.
	* @param name - name.
	* @param age - age.
	* @param university - university.
	* @param recommendations - recommendations.
	* @param aScore - aScore.
	*/
    public Doctor(String name, int age, String university, String recommendations, int aScore) {
        super(name, age, university, recommendations, aScore);
        this.internship = internship;
        this.residency = residency;
    }
}