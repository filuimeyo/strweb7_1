package by.iba.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginRequiredFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpResp = (HttpServletResponse) response;
        HttpSession session = httpReq.getSession();
        if (session.getAttribute("name")!=null) {
            chain.doFilter(request, response);
        }
        else {

// httpResp.sendRedirect(httpReq.getContextPath() + "/LoginServlet");
            session.invalidate();
            request.getRequestDispatcher("LoginServlet").forward(request,
                    response);
        }

    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
