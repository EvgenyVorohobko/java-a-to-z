package by.vorokhobko.database;

import by.vorokhobko.hiberUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * AreaCarsDatabase.
 *
 * Abstract class AreaCarsDatabase is the inner part of the work with the database part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 15.10.2018.
 * @version 1.
 */
public abstract class AreaCarsDatabase<V> {
    /**
     * The class field.
     */
    private final SessionFactory factory = HibernateUtil.getSessionFactory();

    private <V> V tx(final Function<Session, V> command) {
        final Session session = this.factory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            transaction.commit();
            session.close();
        }
    }

    private void init(final Consumer<Session> workWithSession) {
        final Session session = this.factory.openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            workWithSession.accept(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
        } finally {
            transaction.commit();
            session.close();
        }
    }
    /**
     * The method adds car in areaCarsDatabase.
     * @param value - value.
     */
    public void save(V value) {
        this.init(session -> session.save(value));
    }
    /**
     * The method updates status car in areaCarsDatabase.
     * @param value - value.
     */
    public void updateStatus(V value) {
        this.init(session -> session.update(value));
    }
    /**
     * The method delete car in areaCarsDatabase.
     * @param id - id.
     */
    public void delete(int id) {
        this.init(session -> session.delete(id));
    }
    /**
     * The method get all cars in areaCarsDatabase.
     * @return tag.
     */
    public List<V> getAll() {
        return this.tx(session -> session.createQuery("FROM Car").list());
    }

    public V getId(int id) {
        return (V)this.tx(session -> session.get("id", id));
    }
}