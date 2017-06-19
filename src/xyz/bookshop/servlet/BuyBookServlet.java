package xyz.bookshop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by PC on 2017/6/19.
 */
@WebServlet(urlPatterns = {"/buybook"})
public class BuyBookServlet extends MapJspServlet {
    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
    }
}
