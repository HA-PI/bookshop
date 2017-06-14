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

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
    }
}