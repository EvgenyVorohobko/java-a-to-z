package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.html.SimpleBuilder;
import by.vorokhobko.servletwithuser.User;
import by.vorokhobko.servletwithuser.UserStore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ShowAllElement.
 *
 * Class ShowAllElement is the part of the work with web-service part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 03.02.2018.
 * @version 1.
 */
public class ShowAllElement extends SimpleServlet {
    /**
     * The method handle a Post request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        UserStore users = UserStore.INSTANCE;
        List<User> user = users.findAll();
        SimpleBuilder builder = new SimpleBuilder();
        writer.append(builder.showUsers(user, req.getContextPath()));
        writer.flush();
    }
}