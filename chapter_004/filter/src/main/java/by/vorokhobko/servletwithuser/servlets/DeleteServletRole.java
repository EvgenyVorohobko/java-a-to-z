package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DeleteServletRole.
 *
 * Class DeleteServletRole is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class DeleteServletRole extends SimpleServlet {
    /**
     * The method handle a Get request.
     * @param resp - resp.
     * @param req - req.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("role", getUsers().searchId(req.getParameter("id")));
        this.forward("/WEB-INF/view/deleterole.jsp", req, resp);
    }
    /**
     * The method handle a Delete request.
     * @param resp - resp.
     * @param req - req.
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        getUsers().removeRole(id);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}