package by.vorokhobko.database;

import by.vorokhobko.models.Order;

/**
 * OrderDatabase.
 *
 * Class OrderDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class OrderDatabase extends AreaCarsDatabase<Order> {
    /**
     * The class field.
     */
    private static final OrderDatabase INSTANCE = new OrderDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static OrderDatabase getINSTANCE() {
        return INSTANCE;
    }

}