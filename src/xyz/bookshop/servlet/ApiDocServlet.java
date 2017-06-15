package xyz.bookshop.servlet;

import xyz.bookshop.utils.Convert;
import xyz.bookshop.utils.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by moyu on 2017/6/14.
 */
@WebServlet(name = "ApiDocServlet", urlPatterns = {"/doc/api/data"})
public class ApiDocServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS");
        response.setContentType("text/plain");

        String ymlPath = request.getServletContext().getRealPath("/WEB-INF/api-doc.yml");
        /*Enumeration<String> names = request.getHeaderNames();
        Map<String, String> headers = new LinkedHashMap<String, String>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            headers.put(name, request.getHeader(name));
        }

        String json = Request.execute(
            "GET",
            "https://app.swaggerhub.com/apiproxy/schema/file/HA-PI/bookshop/1.0.0/swagger.json",
            null,
                headers
        );*/


//        String json = Convert.yaml2JSON(new FileInputStream(ymlPath));
        int n = -1;
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(ymlPath), "utf-8");
//        StringBuffer stringBuffer = new StringBuffer();
        char buf[] = new char[1024];
        Writer wr = response.getWriter();
//        StringReader sb = new StringReader();
        while ((n = inputStreamReader.read(buf)) > 0) {
//            sb.read(buf);
            wr.write(buf, 0, n);
        }
        System.out.println(n);
        inputStreamReader.close();

    }
}
