package by.iba.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LoginRequiredFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if ("admin".equals(request.getSession().getAttribute("name"))) {
            chain.doFilter(req, resp);
        } else {
            request.getSession().invalidate();
            request.getRequestDispatcher("LoginServlet").forward(req, resp);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
