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
import java.util.List;

@WebServlet(name = "LogListServlet")
public class LogListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogDao logDao = new LogDaoImpl();
        HttpSession session = request.getSession();
        List<Log> logList = logDao.getLogListByUsername((String) session.getAttribute("user"));
        request.setAttribute("logList",logList);
        request.getRequestDispatcher("loglist.jsp").forward(request,response);
    }
}
