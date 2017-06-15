package xyz.bookshop.filter.ajax;

import xyz.bookshop.entity.User;
import xyz.bookshop.utils.Convert;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by moyu on 2017/6/11.
 */
@WebFilter(urlPatterns = {"/api/user/login", "/api/user/register"})
public class LoggedFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        System.out.println("ajax loggedFilter");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // already logged in
            response.getWriter().write(Convert.standardize(400, user.getUsername()+" 已经登录了"));
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
