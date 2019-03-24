package by.vorokhobko.database;

import by.vorokhobko.models.Owner;

/**
 * OwnerDatabase.
 *
 * Class OwnerDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public class OwnerDatabase extends AreaCarsDatabase<Owner> {
    /**
     * The class field.
     */
    private static final OwnerDatabase INSTANCE = new OwnerDatabase();
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static OwnerDatabase getINSTANCE() {
        return INSTANCE;
    }
    /**
     * The method updates a user to database.
     * @param login - login.
     * @param password - password.
     */
    public boolean compareLoginAndPassword(String login, String password) {
        boolean isNeedSave = false;
        for (Owner owner : this.getAll()) {
            if (login.equals(owner.getLogin()) && password.equals(owner.getPassword())) {
                isNeedSave = true;
                break;
            }
        }
        return isNeedSave;
    }
    /**
     * The method updates a user to database.
     * @param login - login.
     * @param password - password.
     */
    public Owner searchLoginAndPassword(String login, String password) {
        Owner result = null;
        for (Owner user : this.getAll()) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                result = user;
                break;
            }
        }
        return result;
    }
}