package xyz.bookshop.servlet;


import xyz.bookshop.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "indexServlet", urlPatterns = {"", "/index"})
public class IndexServlet extends MapJspServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Object user = session.getAttribute("user");
        UserDao u= new UserDao();
        request.setAttribute("data", new Object[]{"ele0", 1888, -2});
        request.setAttribute("user", user);
    }
}