package by.vorokhobko.servlets;

import by.vorokhobko.database.DatabaseImp;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UpdateStatusItems.
 *
 * Class UpdateStatusItems is the part of the work with web-service part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.09.2018.
 * @version 1.
 */
public class UpdateStatusItems extends HttpServlet {
    /**
     * The method handle a Post request.
     * @param req - req.
     * @param resp - resp.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        DatabaseImp.getINSTANCE().updateStatusItem(Integer.parseInt(req.getParameter("id")),
                !Boolean.valueOf(req.getParameter("isDone")));
    }
}