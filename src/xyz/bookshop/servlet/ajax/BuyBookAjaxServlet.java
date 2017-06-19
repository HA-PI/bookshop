package xyz.bookshop.servlet.ajax;

import xyz.bookshop.dao.*;
import xyz.bookshop.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by PC on 2017/6/19.
 */
@WebServlet(name = "BuyBookAjaxServlet", urlPatterns = {"/api/buyrecord/buy"})
public class BuyBookAjaxServlet extends AjaxServlet {
    @Override
    protected int getMethod() {
        return METHOD_POST;
    }

    @Override
    protected String[] getRequiredFields() {
        return new String[] {"bookid","bookname","buynumber"};
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, ServletException {
        String username = ((User) session.getAttribute("user")).getUsername();
        String bookid = req.getParameter("bookid");
        String bookname = req.getParameter("bookname");
        int buynumber = Integer.parseInt(req.getParameter("buynumber"));
        BookDao bookDao = new BookDao();
        Book book= bookDao.find(bookid);
        if (new BuyRecordDao().insert(new BuyRecord(username, buynumber,Integer.parseInt(bookid),bookname,
                book.getAuthor(), book.getPrice(), book.getPress(),book.getImg(),book.getImgtype()))) {
            resp.getWriter().write(standardize(200, "书：《" + bookname + "》购买成功"));
        } else {
            resp.getWriter().write(standardize(400, "书：《" + bookname + "》购买失败"));
        }
    }
}
