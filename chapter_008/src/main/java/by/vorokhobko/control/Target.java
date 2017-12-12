package by.vorokhobko.control;

/**
 * Target.
 *
 * Class Target to create a basic data object part 008, lesson 5.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.12.2017.
 * @version 1.
 */
public class Target {
    /**
     * The class field.
     */
    private long id;
    /**
     * The class field.
     */
    private String vacancy;
    /**
     * The class field.
     */
    private String description;
    /**
     * The class field.
     */
    private String creates;
    /**
     * Add Item.
     * @param vacancy - vacancy.
     * @param description - description.
     * @param creates - create.
     */
    public Target(String vacancy, String description, String creates) {
        this.vacancy = vacancy;
        this.description = description;
        this.creates = creates;
    }
    /**
     * Add setter Id.
     * @param id - id.
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Add override toString.
     * @return tag.
     */
    @Override
    public String toString() {
        return "id = " + id + ", vacancy ='" + vacancy + ", description = '"
                + description + ", creates = '" + creates;
    }
}