package by.vorokhobko.servlets;

import by.vorokhobko.database.DatabaseImp;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DeleteItems.
 *
 * Class DeleteItems is the part of the work with web-service part 010, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 12.09.2018.
 * @version 1.
 */
public class DeleteItems extends HttpServlet {
    /**
     * The method handle a Post request.
     * @param req - req.
     * @param resp - resp.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        DatabaseImp.getINSTANCE().deleteItem(Integer.parseInt(req.getParameter("id")));
    }
}