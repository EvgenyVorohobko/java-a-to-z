package by.vorokhobko.servletwithuser.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 17.06.2018.
 */
public class JsonController extends HttpServlet {
    /**
     * .
     * @param req request from client to server.
     * @param resp response from server to client.
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(String.valueOf(session.getAttribute("user") != null));
        writer.flush();
    }
}