package by.vorokhobko.database;

import by.vorokhobko.models.Car;

/**
 * CarDatabase.
 *
 * Class CarDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class CarDatabase extends AreaCarsDatabase<Car> {
    /**
     * The class field.
     */
    private static final CarDatabase INSTANCE = new CarDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static CarDatabase getINSTANCE() {
        return INSTANCE;
    }
}