package servlet;

import dao.LogDao;
import dao.LogDaoImpl;
import entity.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserLogListServlet")
public class UserLogListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        LogDao logDao = new LogDaoImpl();
        List<Log> list = logDao.getLogListByUserId(id);
        request.setAttribute("logList",list);
        request.setAttribute("uid",id);
        request.getRequestDispatcher("loglist.jsp").forward(request,response);
    }
}
