package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
     * The method handle a Get request.
     * @param req - req.
     * @param resp - resp.
     * @throws IOException tag.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        List<User> users = getUsers().findAll();
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(users));
        writer.flush();
    }
    /**
     * The method handle a Post request.
     * @param req - req.
     * @param resp - resp.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("loginUpdate", req.getParameter("login"));
    }
}