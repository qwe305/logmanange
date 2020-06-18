package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        HttpSession session = request.getSession();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        User res = userDao.checkLogin(user);
        if(res!=null){
            session.setAttribute("user",user.getUsername());
            session.setAttribute("role",res.getRole());
            session.setAttribute("id",res.getId());
            if(res.getRole()==1){
                response.sendRedirect("userlist");
            }else{
                response.sendRedirect("loglist");
            }
        }else{
            request.setAttribute("msg","账号或密码错误，登录失败");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
