package xyz.bookshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by moyu on 2017/6/11.
 */
@WebFilter(filterName="jspUrlFilter", urlPatterns = {"*.jsp"})
public class JspUrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        System.out.println("jspUrlFilter");
        String url = request.getRequestURI();
        int i = url.indexOf(".jsp");
        response.sendRedirect(url.substring(0, i));
    }

    @Override
    public void destroy() {

    }
}
