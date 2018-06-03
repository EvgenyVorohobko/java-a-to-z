package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CreateServletRole.
 *
 * Class CreateServletRole is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class CreateServletRole extends SimpleServlet {
    /**
     * The method handle a Get request.
     * @param resp - resp.
     * @param req - req.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.forward("/WEB-INF/view/addrole.jsp", req, resp);
    }
    /**
     * The method handle a Post request.
     * @param resp - resp.
     * @param req - req.
     * @throws IOException IOException.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        getUsers().addRole(new Role(req.getParameter("name")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}