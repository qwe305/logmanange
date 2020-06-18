package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;
        int role=0;
        if(session.getAttribute("role")!=null){
            role = (int) session.getAttribute("role");
            if(role==1){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("msg","你无权访问");
                request.getRequestDispatcher("/userlist.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("msg","你无权访问");
            request.getRequestDispatcher("/userlist.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
