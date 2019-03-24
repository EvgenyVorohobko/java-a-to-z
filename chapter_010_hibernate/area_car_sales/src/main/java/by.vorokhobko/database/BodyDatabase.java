package by.vorokhobko.database;

import by.vorokhobko.models.Body;

/**
 * BodyDatabase.
 *
 * Class BodyDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class BodyDatabase extends AreaCarsDatabase<Body> {
    /**
     * The class field.
     */
    private static final BodyDatabase INSTANCE = new BodyDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static BodyDatabase getINSTANCE() {
        return INSTANCE;
    }
}