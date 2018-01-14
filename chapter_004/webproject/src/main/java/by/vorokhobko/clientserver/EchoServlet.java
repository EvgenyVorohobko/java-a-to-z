package by.vorokhobko.clientserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * EchoServlet.
 *
 * Class EchoServlet is the part of the work with web-service part 004, lesson 1.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 13.01.2018.
 * @version 1.
 */
public class EchoServlet extends HttpServlet {
    /**
     * The class field.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);
    /**
     * The method handle a GET request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hello world");
        writer.flush();
    }
}