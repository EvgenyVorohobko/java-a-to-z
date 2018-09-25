package by.vorokhobko.database;

import by.vorokhobko.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseImp.
 *
 * Class DatabaseImp is the inner part of the work with the database part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.09.2018.
 * @version 1.
 */
public class DatabaseImp implements Database {
    /**
     * The class field.
     */
    private static final DatabaseImp INSTANCE = new DatabaseImp();
    /**
     * The class field.
     */
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    /**
     * Add constructor.
     */
    private DatabaseImp() {
    }
    /**
     * Add getter INSTANCE.
     * @return tag.
     */
    public static DatabaseImp getINSTANCE() {
        return INSTANCE;
    }
    /**
     * The method adds item to database.
     * @param description - description.
     */
    @Override
    public void addItem(String description) {
        Transaction transaction = null;
        try (Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            Item item = new Item();
            item.setDescription(description);
            item.setCreateDate(new Timestamp(System.currentTimeMillis()));
            session.save(item);
            transaction.commit();
            session.close();
        }
    }
    /**
     * The method updates status item in database.
     * @param id - id.
     * @param isDone - isDone.
     */
    @Override
    public void updateStatusItem(int id, boolean isDone) {
        Transaction transaction = null;
        try (Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            Item item = session.get(Item.class, id);
            item.setDone(isDone);
            session.update(item);
            transaction.commit();
            session.close();
        }
    }
    /**
     * The method delete item in database.
     * @param id - id.
     */
    @Override
    public void deleteItem(int id) {
        Transaction transaction = null;
        try (Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            Item item = session.get(Item.class, id);
            session.delete(item);
            transaction.commit();
            session.close();
        }
    }
    /**
     * The method get all item in database.
     * @return tag.
     */
    @Override
    public List<Item> getAllItems(boolean isDone) {
        List<Item> itemsList = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = this.factory.openSession()) {
            transaction = session.beginTransaction();
            itemsList = session.createQuery("FROM Item").list();
            transaction.commit();
            session.close();
        }
        return itemsList;
    }
}