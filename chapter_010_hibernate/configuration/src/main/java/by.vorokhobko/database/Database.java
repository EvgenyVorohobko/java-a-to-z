package by.vorokhobko.database;

import by.vorokhobko.models.Item;
import java.util.List;

/**
 * Database.
 *
 * Interface DatabaseImp is the inner part of the work with the database part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.09.2018.
 * @version 1.
 */
public interface Database {
    /**
     * The method adds item to database.
     * @param description - description.
     */
    void addItem(String description);
    /**
     * The method updates status item in database.
     * @param id - id.
     * @param isDone - isDone.
     */
    void updateStatusItem(int id, boolean isDone);
    /**
     * The method delete item in database.
     * @param id - id.
     */
    void deleteItem(int id);
    /**
     * The method get all item in database.
     * @return tag.
     */
    List<Item> getAllItems(boolean isDone);
}