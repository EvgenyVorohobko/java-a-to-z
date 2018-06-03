package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UpdateServletRole.
 *
 * Class UpdateServletRole is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class UpdateServletRole extends SimpleServlet {
    /**
     * The method handle a Get request.
     * @param resp - resp.
     * @param req - req.
     * @throws ServletException ServletException.
     * @throws IOException IOException.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", getUsers().findAllRole());
        this.forward("/WEB-INF/view/updaterole.jsp", req, resp);
    }
}