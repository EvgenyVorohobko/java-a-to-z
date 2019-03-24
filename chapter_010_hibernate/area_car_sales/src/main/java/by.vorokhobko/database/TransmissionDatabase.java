package by.vorokhobko.database;

import by.vorokhobko.models.Transmission;

/**
 * TransmissionDatabase.
 *
 * Class TransmissionDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class TransmissionDatabase extends AreaCarsDatabase<Transmission> {
    /**
     * The class field.
     */
    private static final TransmissionDatabase INSTANCE = new TransmissionDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static TransmissionDatabase getINSTANCE() {
        return INSTANCE;
    }
}