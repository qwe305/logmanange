package servlet;

import dao.LogDao;
import dao.LogDaoImpl;
import entity.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddLogServlet")
public class AddLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        Log log = new Log();
        log.setTitle(title);
        log.setContent(content);
        log.setUserId((Integer) session.getAttribute("id"));
        LogDao logDao = new LogDaoImpl();
        logDao.addLog(log);
        response.sendRedirect("loglist");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
