package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DeleteServlet.
 *
 * Class DeleteServlet is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class DeleteServlet extends SimpleServlet {
    /**
     * The method handle a Delete request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        getUsers().removeUser(id);
        resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
    }
}