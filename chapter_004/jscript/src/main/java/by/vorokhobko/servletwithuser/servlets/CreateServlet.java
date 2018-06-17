package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * CreateServlet.
 *
 * Class CreateServlet is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class CreateServlet extends SimpleServlet {
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        getUsers().addUser(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                new Timestamp(System.currentTimeMillis()),
                req.getParameter("password"),
                req.getParameter("role"),
                req.getParameter("country"),
                req.getParameter("town")
        ));
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(String.format("%s/create.html", req.getContextPath()));
    }
}