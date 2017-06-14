package xyz.bookshop.servlet;

import xyz.bookshop.dao.UserDao;
import xyz.bookshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Yc on 2016/4/8 for students_system.
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends MapJspServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao= new UserDao();
        HttpSession session=request.getSession();
        User l=(User) session.getAttribute("login");
        if(l==null) l = userDao.checkLogin(request.getParameter("usename"), request.getParameter("password"));
        if(l!=null){                                      //如果登陆成功
            session.setAttribute("login",l);
            response.sendRedirect("index.jsp");
        }
        else{

        }
    }

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

    }
}