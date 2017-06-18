package xyz.bookshop.servlet.ajax;

import xyz.bookshop.dao.BookDao;
import xyz.bookshop.entity.Book;
import xyz.bookshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.lang.*;
import java.sql.*;

/**
 * Created by PC on 2017/6/16.
 */
@WebServlet(name = "AddBookAjaxServlet", urlPatterns = {"/api/book/add"})
@MultipartConfig
public class AddBookAjaxServlet extends AjaxServlet {
    @Override
    protected int getMethod() {
        return METHOD_POST;
    }

    @Override
    protected String[] getRequiredFields() {
        return new String[]{"name", "author", "price", "press", "press", "number"};
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, ServletException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        float price = Float.parseFloat(req.getParameter("price"));
        String press = req.getParameter("press");
        int number = Integer.parseInt(req.getParameter("number"));
        InputStream img = req.getPart("img").getInputStream();
        String imgtype = req.getPart("img").getContentType();
        String belong = ((User) session.getAttribute("user")).getUsername();

        if (new BookDao().insert(new Book(name, author, price, number, press, img, imgtype, belong))) {
            resp.getWriter().write(standardize(200, "书：《" + name + "》添加成功"));
        } else {
            resp.getWriter().write(standardize(400, "书：《" + name + "》添加失败"));
        }
    }
}

