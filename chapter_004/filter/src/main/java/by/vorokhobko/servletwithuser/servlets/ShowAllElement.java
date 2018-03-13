package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ShowAllElement.
 *
 * Class ShowAllElement is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 21.02.2018.
 * @version 1.
 */
public class ShowAllElement extends SimpleServlet {
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("users", getUsers().findAll());
        forward("/WEB-INF/view/show.jsp", req, resp);
    }
}