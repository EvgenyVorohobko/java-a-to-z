package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * UpdateServlet.
 *
 * Class UpdateServlet is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class UpdateServlet extends SimpleServlet {
    /**
     * The method handle a Put request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getUsers().updateUser(
                Integer.parseInt(req.getParameter("id")),
                new User(req.getParameter("name"),
                        req.getParameter("login"),
                        req.getParameter("email"),
                        new Timestamp(System.currentTimeMillis()),
                        req.getParameter("password"),
                        req.getParameter("role"),
                        req.getParameter("country"),
                        req.getParameter("town")
                ));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
    /**
     * The method handle a Put request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/json");
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        User user = getUsers().searchUser(id);
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(user));
        writer.flush();
    }
}