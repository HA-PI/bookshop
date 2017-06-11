package xyz.bookshop.servlet;

import a.b.Name;

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
@WebServlet(name = "indexServlet", urlPatterns = {"", "/index"})
public class IndexServlet extends MapJspServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Object user = session.getAttribute("user");
        request.setAttribute("data", new Object[]{"ele0", 1, -2});
        request.setAttribute("user", user);
    }
}