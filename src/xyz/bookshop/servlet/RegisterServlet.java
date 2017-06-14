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
import xyz.bookshop.dao.*;
import xyz.bookshop.entity.*;
/**
 *
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends MapJspServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        User user = new User(name,password);
        if(new UserDao().insertUser( name,password)){
            response.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

    }
}