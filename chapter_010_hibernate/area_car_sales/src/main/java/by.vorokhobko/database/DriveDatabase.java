package by.vorokhobko.database;

import by.vorokhobko.models.Drive;

/**
 * DriveDatabase.
 *
 * Class DriveDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class DriveDatabase extends AreaCarsDatabase<Drive> {
    /**
     * The class field.
     */
    private static final DriveDatabase INSTANCE = new DriveDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static DriveDatabase getINSTANCE() {
        return INSTANCE;
    }
}