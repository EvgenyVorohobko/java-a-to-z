package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.html.SimpleBuilder;
import by.vorokhobko.servletwithuser.User;
import by.vorokhobko.servletwithuser.UserStore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * UpdateServlet.
 *
 * Class UpdateServlet is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.02.2018.
 * @version 1.
 */
public class UpdateServlet extends SimpleServlet {
    /**
     * The method handle a Put request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        SimpleBuilder builder = new SimpleBuilder();
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        String element;
        if (id == null) {
            element = builder.notEditUser(req.getContextPath());
        } else {
            UserStore users = UserStore.INSTANCE;
            users.updateUser(
                    Integer.parseInt(req.getParameter("id")),
                    new User(req.getParameter("name"),
                    req.getParameter("login"),
                    req.getParameter("email"),
                    new Timestamp(System.currentTimeMillis())
            ));
            element = builder.editUser(req.getContextPath(), Integer.valueOf(id));
        }
        writer.append(element);
        writer.flush();
    }
}