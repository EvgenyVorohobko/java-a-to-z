package by.vorokhobko.database;

import by.vorokhobko.models.Price;

/**
 * PriceDatabase.
 *
 * Class PriceDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class PriceDatabase extends AreaCarsDatabase<Price> {
    /**
     * The class field.
     */
    private static final PriceDatabase INSTANCE = new PriceDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static PriceDatabase getINSTANCE() {
        return INSTANCE;
    }
}