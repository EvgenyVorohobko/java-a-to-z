package by.vorokhobko.database;

import by.vorokhobko.models.Fuel;

/**
 * GetFuel.
 *
 * Class GetFuel is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class FuelDatabase extends AreaCarsDatabase<Fuel> {
    /**
     * The class field.
     */
    private static final FuelDatabase INSTANCE = new FuelDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static FuelDatabase getINSTANCE() {
        return INSTANCE;
    }
}