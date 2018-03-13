package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.ServletException;
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
     * The method handle a Get request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", getUsers().searchId(req.getParameter("id")));
        this.forward("/WEB-INF/view/delete.jsp", req, resp);
    }
    /**
     * The method handle a Delete request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        getUsers().removeUser(id);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}