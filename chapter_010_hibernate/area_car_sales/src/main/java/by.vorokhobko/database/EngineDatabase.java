package by.vorokhobko.database;

import by.vorokhobko.models.Engine;

/**
 * EngineDatabase.
 *
 * Class EngineDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class EngineDatabase extends AreaCarsDatabase<Engine> {
    /**
     * The class field.
     */
    private static final EngineDatabase INSTANCE = new EngineDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static EngineDatabase getINSTANCE() {
        return INSTANCE;
    }
}