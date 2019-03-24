package by.vorokhobko.database;

import by.vorokhobko.models.Location;

/**
 * LocationDatabase.
 *
 * Class LocationDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class LocationDatabase extends AreaCarsDatabase<Location> {
    /**
     * The class field.
     */
    private static final LocationDatabase INSTANCE = new LocationDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static LocationDatabase getINSTANCE() {
        return INSTANCE;
    }
}