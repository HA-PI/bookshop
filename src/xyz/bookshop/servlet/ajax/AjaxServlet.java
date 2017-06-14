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
@WebServlet(name = "AjaxServlet")
abstract public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        methodCheckService(request, response, METHOD_POST);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        methodCheckService(request, response, METHOD_GET);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        methodCheckService(req, resp, METHOD_ALL);
    }

    private void methodCheckService(HttpServletRequest req, HttpServletResponse resp, int method) throws IOException {
        if (getMethod() == method) {
            commonService(req, resp);
        } else {
            resp.sendError(502, "Forbid Method: "+req.getMethod());
        }
    }

    protected static int METHOD_ALL = 0;
    protected static int METHOD_POST = 1;
    protected static int METHOD_GET = 2;

    protected int getMethod() {
        return METHOD_ALL;
    }

    private void commonService(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String errorMsg = getRequiredFieldsErrMsg(req);
        if (errorMsg != null) {
            resp.sendError(500, errorMsg);
            return;
        }
        workspace(req, resp, session);
    }

    protected abstract void workspace(HttpServletRequest req, HttpServletResponse resp, HttpSession session);


    protected String standardize(int code, Object data) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("data", data);
        return json.toString();
    }

    private String getRequiredFieldsErrMsg(HttpServletRequest req) {
        String[] fields = getRequiredFields();
        for (String field : fields) {
            if (null == req.getAttribute(field)){
                return "Error: \"" + field + "\" field is required.";
            }
        }
        return null;
    }

    protected abstract String[] getRequiredFields();
}
