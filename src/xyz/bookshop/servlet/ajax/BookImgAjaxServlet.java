package xyz.bookshop.servlet.ajax;

import xyz.bookshop.dao.BookDao;
import xyz.bookshop.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.Channel;

/**
 * Created by PC on 2017/6/16.
 */
@WebServlet(name = "BookImgAjaxServlet", urlPatterns = {"/book/img"})
public class BookImgAjaxServlet extends AjaxServlet {
    @Override
    protected int getMethod() {
        return METHOD_ALL;
    }

    @Override
    protected void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, ServletException {
        String id = req.getParameter("id");
        BookDao b = new BookDao();
        Book book = b.find(id);
        InputStream stream = null;
        OutputStream out = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        if (book != null && (stream = book.getImg()) != null) {
            int n = -1;
            resp.setContentType(book.getImgtype());
            while ((n = stream.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
        }
    }

    @Override
    protected String[] getRequiredFields() {
        return new String[]{"id"};
    }
}
