package xyz.bookshop.servlet;


import xyz.bookshop.dao.BookDao;
import xyz.bookshop.dao.UserDao;
import xyz.bookshop.entity.Book;
import xyz.bookshop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "indexServlet", urlPatterns = {"", "/index"})
public class IndexServlet extends MapJspServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void initRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UserDao u= new UserDao();
        BookDao b= new BookDao();
        Book book new Book();
        int page=0;
        int pageSize=4;
        if(u.exists(user)){




        }else{

        }
        request.setAttribute("data", new Object[]{"book", "", ""});




    }
}