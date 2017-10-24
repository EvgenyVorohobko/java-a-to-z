package by.vorokhobko.inheritance;

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
    }
    /**
     * Getter to specify the age.
     * @return tag.
     */
    public int getInternship() {
        return this.internship;
    }
    /**
     * Setter to specify the internship.
     * @param internship - internship.
     */
    public void setInternship(int internship) {
        this.internship = internship;
    }
    /**
     * Setter to specify the residency.
     * @param residency - residency.
     */
    public void setResidency(int residency) {
        this.residency = residency;
    }
    /**
     * Getter to specify the age.
     * @return tag.
     */
    public int getResidency() {
        return this.residency;
    }
}