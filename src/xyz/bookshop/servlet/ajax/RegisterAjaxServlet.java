package xyz.bookshop.servlet.ajax;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by moyu on 2017/6/14.
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/api/register"})
public class RegisterAjaxServlet extends AjaxServlet {

    @Override
    protected int getMethod() {
        return METHOD_POST;
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

    }

    @Override
    protected String[] getRequiredFields() {
        return new String[]{"username", "password"};
    }
}
