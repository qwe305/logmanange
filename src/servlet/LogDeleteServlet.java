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

@WebServlet(name = "LogDeleteServlet")
public class LogDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        LogDao logDao = new LogDaoImpl();
        logDao.deleteLogById(id);
        String userid=request.getParameter("uid");
        if(userid==null||"".equals(userid)){
            List<Log> logList = logDao.getLogListByUsername((String) session.getAttribute("user"));
            request.setAttribute("logList",logList);
        }else{
            List<Log> logList = logDao.getLogListByUserId(Integer.parseInt(userid));
            request.setAttribute("logList",logList);
        }
        request.getRequestDispatcher("loglist.jsp").forward(request,response);
    }
}
