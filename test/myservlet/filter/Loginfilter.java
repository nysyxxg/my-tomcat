package myservlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
@WebFilter(filterName = "Loginfilter", urlPatterns = {"/*"})
public class Loginfilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest reqs = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println(" req.getRequestURI() " + reqs.getRequestURI());

        String requestURI = reqs.getRequestURI();
        // 获取请求地址
//        String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/", 1),
//                req.getRequestURI().length());

        // 登陆页面和接口放开限制，否则死循环
        if (requestURI.endsWith("/login.html")  || requestURI.endsWith("/loginServlet")) {
            chain.doFilter(reqs, res);
        } else {
            // 默认不开启
            HttpSession session = reqs.getSession(false);
            // 如果session中没有用户信息，拦截返回登陆页面
            if (session == null || session.getAttribute("username") == null) {
                System.out.println(session);
                res.sendRedirect(reqs.getContextPath() + "/login.html");
                // 返回
                return;
            } else {
                System.out.println(session);
                chain.doFilter(reqs, res);
            }
        }
    }



    public void init(FilterConfig config) throws ServletException {

    }

}