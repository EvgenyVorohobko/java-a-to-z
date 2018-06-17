package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;
import by.vorokhobko.servletwithuser.UserStore;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * AuthFilter.
 *
 * Class AuthFilter is the part of the work with web-service with control user entered part 004, lesson 6.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 27.02.2018.
 * @version 1.
 */
public class AuthFilter implements Filter {
    /**
     * The method starts working with the database.
     * @param filterConfig - filterConfig.
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }
    /**
     * The method handle a doFilter request.
     * @param servletRequest - servletRequest.
     * @param servletResponse - servletResponse.
     * @param filterChain - filterChain.
     * @throws IOException tag.
     * @throws ServletException tag.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("/login.html") || session.getAttribute("user") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session.getAttribute("user") == null || servletRequest.getParameter("login") == null) {
            ((HttpServletResponse) servletResponse).sendRedirect(String.format("%s/login.html", request.getContextPath()));
        } else {
            User user = UserStore.INSTANCE.searchElementInDatabase(servletRequest.getParameter("login"), servletRequest.getParameter("password"));
            session.setAttribute("user", user);
            session.setAttribute("login", servletRequest.getParameter("login"));
            session.setAttribute("password", servletRequest.getParameter("password"));
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    /**
     * The method closes working with the database.
     */
    @Override
    public void destroy() {

    }
}