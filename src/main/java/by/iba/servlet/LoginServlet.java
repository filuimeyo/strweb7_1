package by.iba.servlet;

import by.iba.model.ListService;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Good morning </title>");
        out.println("</head>");
        out.println("<body>");
        out.println(" First Servlet");
        out.println("</body>");
        out.println("</html>");*/

        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* req.setCharacterEncoding("UTF-8");
        req.setAttribute("name", req.getParameter("name"));
        req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
*/



        String name = req.getParameter("name");
        String password = req.getParameter("password");



        if (validateUser(name, password)) {
            req.getSession().setAttribute("name", name);
            /*req.setAttribute("group", ListService.retrieveList());
            req.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                    .forward(req, resp);*/
            resp.sendRedirect(req.getContextPath() + "/GroupListServlet");
// НЕТ ПАРАМЕТРОВ - всегда использует метод get request.getRequestDispatcher("/GroupServlet")
//.forward(request, response);
        } else {
            req.setAttribute("errorMessage", "Invalid Login and password!!");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(req, resp);
        }


    }
}
