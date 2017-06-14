package xyz.bookshop.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yc on 2016/4/8 for students_system.
 */
@WebServlet(urlPatterns = {})
public abstract class MapJspServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 初始化对象的方法
     * @param request
     * @param response
     * @param session
     */
    protected abstract void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        initRequest(request, response, session);

        String url = request.getRequestURI();
        while (url.startsWith("/")) {
            url = url.substring(1);
        }
        if (url.isEmpty()) {
            url = "index";
        }
//        System.out.println(url);
        if (url.endsWith(".jsp")) {
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }
        request.getRequestDispatcher(url + ".jsp").forward(request, response);

    }
}