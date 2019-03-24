package by.vorokhobko.database;

import by.vorokhobko.models.Year;

/**
 * YearDatabase.
 *
 * Class YearDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class YearDatabase extends AreaCarsDatabase<Year> {
    /**
     * The class field.
     */
    private static final YearDatabase INSTANCE = new YearDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static YearDatabase getINSTANCE() {
        return INSTANCE;
    }
}