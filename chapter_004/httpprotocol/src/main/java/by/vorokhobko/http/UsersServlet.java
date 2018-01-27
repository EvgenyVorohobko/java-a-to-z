package by.vorokhobko.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * UsersServlet.
 *
 * Class UsersServlet is the part of the work with web-service part 004, lesson 2.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.01.2018.
 * @version 1.
 */
public class UsersServlet extends HttpServlet {
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(HttpServlet.class);
    /**
     * The class field.
     */
    private UserStore users = UserStore.INSTANCE;
    /**
     * The method starts working with the database.
     */
    @Override
    public void init() throws ServletException {
        this.users.createConnection();
        this.users.createTable();
    }
    /**
     * The method handle a GET request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        for (User user : users.findAll()) {
            writer.append(user.toString());
            writer.append(System.getProperty("line.separator"));
            writer.flush();
        }
    }
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.addUser(new User(
                req.getParameter("nameUser"),
                req.getParameter("loginUser"),
                req.getParameter("emailUser"),
                new Timestamp(System.currentTimeMillis())
        ));
    }
    /**
     * The method handle a Put request.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.updateUser(new User(
                req.getParameter("nameUser"),
                req.getParameter("loginUser"),
                req.getParameter("emailUser"),
                new Timestamp(System.currentTimeMillis())
        ));
    }
    /**
     * The method handle a Delete request.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.users.removeUser(Integer.parseInt(req.getParameter("id")));
    }
    /**
     * The method closes working with the database.
     */
    @Override
    public void destroy() {
        this.users.closeConnection();
    }
}