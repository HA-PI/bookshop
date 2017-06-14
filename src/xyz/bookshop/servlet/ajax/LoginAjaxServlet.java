package xyz.bookshop.servlet.ajax;

import xyz.bookshop.dao.UserDao;
import xyz.bookshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by PC on 2017/6/14.
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/api/login"})
public class LoginAjaxServlet extends AjaxServlet {
    @Override
    protected int getMethod() {
        return METHOD_GET;
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ((username.length() < 6 && username.length() > 10) || (password.length() < 6 && password.length() > 10)) {
            resp.sendError(500, standardize(500, "用户名或者密码长度错误"));
        } else {
            if (new UserDao().checkLogin(new User(username, password))) {
                resp.getWriter().write(standardize(200, "登录成功"));
            } else {
                resp.getWriter().write(standardize(400, "登录失败"));
            }
        }
    }

    @Override
    protected String[] getRequiredFields() {
        return new String[]{"username", "password"};
    }
}

