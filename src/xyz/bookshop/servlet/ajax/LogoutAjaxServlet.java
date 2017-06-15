package xyz.bookshop.servlet.ajax;

import xyz.bookshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by moyu on 2017/6/15.
 */
@WebServlet(name = "LogoutAjaxServlet", urlPatterns = {"/api/user/logout"})
public class LogoutAjaxServlet extends AjaxServlet {

    @Override
    protected int getMethod() {
        return METHOD_GET;
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        PrintWriter pw = resp.getWriter();
        session.removeAttribute("user");
        pw.write(standardize(200, "登出成功"));
    }

    @Override
    protected String[] getRequiredFields() {
        return new String[0];
    }
}
