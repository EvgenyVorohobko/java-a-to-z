package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if (id == null) {
            this.forward("/WEB-INF/view/notupdate.jsp", req, resp);
        } else {
            getUsers().updateUser(
                    Integer.parseInt(req.getParameter("id")),
                    new User(req.getParameter("name"),
                            req.getParameter("login"),
                            req.getParameter("email"),
                            new Timestamp(System.currentTimeMillis())
                    ));
            this.forward("/WEB-INF/view/update.jsp", req, resp);
        }
    }
}