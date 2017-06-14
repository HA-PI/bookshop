package xyz.bookshop.servlet;

import xyz.bookshop.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends MapJspServlet {

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
    }
}