package by.vorokhobko.database;

import by.vorokhobko.models.Image;

/**
 * ImageDatabase.
 *
 * Class ImageDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class ImageDatabase extends AreaCarsDatabase<Image> {
    /**
     * The class field.
     */
    private static final ImageDatabase INSTANCE = new ImageDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static ImageDatabase getINSTANCE() {
        return INSTANCE;
    }
}