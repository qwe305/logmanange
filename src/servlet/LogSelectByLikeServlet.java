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

@WebServlet(name = "LogSelectByLikeServlet")
public class LogSelectByLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        LogDao logDao = new LogDaoImpl();
        String uid = request.getParameter("uid");
        HttpSession session = request.getSession();
        if(uid==null||"".equals(uid)){
            List<Log> list = logDao.getLogListByUserIdAndTitle((Integer) session.getAttribute("id"),title);
            request.setAttribute("logList",list);
        }else{
            List<Log> list = logDao.getLogListByUserIdAndTitle(Integer.parseInt(uid),title);
            request.setAttribute("uid",uid);
            request.setAttribute("logList",list);
        }
        request.getRequestDispatcher("loglist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
