package by.vorokhobko.inheritance;

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
	/**
	* Class Engineer.
	* @param name - name.
	* @param age - age.
	* @param university - university.
	* @param recommendations - recommendations.
	* @param aScore - aScore.
	*/
    public Engineer(String name, int age, String university, String recommendations, int aScore) {
        super(name, age, university, recommendations, aScore);
    }
    /**
     * Setter to specify the experience.
     * @param experience - experience.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    /**
     * Getter to specify the experience.
     * @return tag.
     */
    public int getExperience() {
        return this.experience;
    }
}