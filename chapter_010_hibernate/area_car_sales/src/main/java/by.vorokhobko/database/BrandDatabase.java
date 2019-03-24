package by.vorokhobko.database;

import by.vorokhobko.models.Brand;

/**
 * BrandDatabase.
 *
 * Class BrandDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class BrandDatabase extends AreaCarsDatabase<Brand> {
    /**
     * The class field.
     */
    private static final BrandDatabase INSTANCE = new BrandDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static BrandDatabase getINSTANCE() {
        return INSTANCE;
    }
}