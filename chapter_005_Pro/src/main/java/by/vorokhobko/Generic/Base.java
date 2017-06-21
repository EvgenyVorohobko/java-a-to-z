package by.vorokhobko.Generic;

/**
 * Base.
 *
 * Class Base abstract class for the program part 005_Pro, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.06.2017.
 * @version 1.
 */
public abstract class Base {
    /**
     * The class field.
     */
    private String id;
    /**
     * Add getter Id.
     * @return tag.
     */
    public String getId() {
        return id;
    }
    /**
     * Add setter Id.
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Create constructor.
     * @param id - id.
     */
    public Base(String id) {
        this.id = id;
    }
}