package xyz.bookshop.servlet.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by PC on 2017/6/16.
 */
@WebServlet(name = "BookImgAjaxServlet",urlPatterns = {"/api/book/img"})
public class BookImgAjaxServlet extends AjaxServlet {
    @Override
    protected int getMethod() {
        return METHOD_GET;
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, ServletException {

    }

    @Override
    protected String[] getRequiredFields() {
        return new String[]{"id"};
    }
}
