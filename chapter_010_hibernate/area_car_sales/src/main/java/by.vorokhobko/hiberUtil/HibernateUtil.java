package by.vorokhobko.hiberUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HibernateUtil.
 *
 * Class HibernateUtil is designed to work with part 010, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 14.10.2018.
 * @version 1.
 */
public class HibernateUtil {
    /**
     * The class field.
     */
    private static SessionFactory sessionFactory;
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
    /**
     * Add getter.
     * @return tag.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable exception) {
                LOG.error("This is error!", exception);
                throw new ExceptionInInitializerError(exception);
            }
        }
        return sessionFactory;
    }
    /**
     * Add method close session.
     */
    public void closeSession() {
        sessionFactory.close();
    }
}