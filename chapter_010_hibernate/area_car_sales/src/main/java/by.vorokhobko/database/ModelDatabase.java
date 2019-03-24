package by.vorokhobko.database;

import by.vorokhobko.models.Model;

/**
 * ModelDatabase.
 *
 * Class ModelDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class ModelDatabase extends AreaCarsDatabase<Model> {
    /**
     * The class field.
     */
    private static final ModelDatabase INSTANCE = new ModelDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static ModelDatabase getINSTANCE() {
        return INSTANCE;
    }
}