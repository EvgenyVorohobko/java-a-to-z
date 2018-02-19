package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.UserStore;
import javax.servlet.http.HttpServlet;

/**
 * SimpleServlet.
 *
 * Class SimpleServlet is the part of the work with user in web-browser part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 19.02.2018.
 * @version 1.
 */
public abstract class SimpleServlet extends HttpServlet {
    /**
     * The class field.
     */
    private UserStore users = UserStore.INSTANCE;
    /**
     * The method starts working with the database.
     */
    @Override
    public void init() {
        this.users.createConnection();
        this.users.createTable();
    }
    /**
     * The method closes working with the database.
     */
    @Override
    public void destroy() {
        this.users.closeConnection();
    }
}
