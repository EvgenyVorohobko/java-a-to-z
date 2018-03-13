package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ControllerServlet.
 *
 * Class ControllerServlet is the part of the work with web-service with control user entered part 004, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 27.02.2018.
 * @version 1.
 */
public class ControllerServlet extends SimpleServlet {
    /**
     * The method handle a Get request.
     * @param req - req.
     * @param resp - resp.
     * @throws IOException tag.
     * @throws ServletException tag.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.forward("/WEB-INF/view/control.jsp", req, resp);
    }
    /**
     * The method handle a Post request.
     * @param req - req.
     * @param resp - resp.
     * @throws IOException tag.
     * @throws ServletException tag.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (UserStore.INSTANCE.compareLoginAndPassword(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", " This user doesn't exist!");
            doGet(req, resp);
        }
    }
}