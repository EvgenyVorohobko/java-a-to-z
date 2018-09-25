package by.vorokhobko.servlets;

import by.vorokhobko.database.DatabaseImp;
import by.vorokhobko.models.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ShowAllItems.
 *
 * Class ShowAllItems is the part of the work with web-service part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.09.2018.
 * @version 1.
 */
public class ShowAllItems extends HttpServlet {
    /**
     * The method handle a Get request.
     * @param req - req.
     * @param resp - resp.
     * @throws IOException tag.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json");
        List<Item> items = DatabaseImp.getINSTANCE().getAllItems(Boolean.valueOf(req.getParameter("isDone")));
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.append(mapper.writeValueAsString(items));
        writer.flush();
    }
}