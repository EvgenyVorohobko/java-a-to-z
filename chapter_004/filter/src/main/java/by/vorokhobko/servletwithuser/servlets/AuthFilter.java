package by.vorokhobko.servletwithuser.servlets;

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
        if (request.getRequestURI().contains("/control")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
                ((HttpServletResponse) servletResponse).sendRedirect(String.format("%s/control", request.getContextPath()));
                return;
            }
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