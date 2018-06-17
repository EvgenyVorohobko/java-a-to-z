package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SimpleServlet.
 *
 * Class SimpleServlet is the part of the work with user in web-browser part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public abstract class SimpleServlet extends HttpServlet {
    /**
     * The class field.
     */
    private UserStore users = UserStore.INSTANCE;
    /**
     * Add getter users.
     * @return tag.
     */
    public UserStore getUsers() {
        return users;
    }
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
    /**
     * The method works in jsp.
     */
    protected void forward(String address, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(req, resp);
    }
}