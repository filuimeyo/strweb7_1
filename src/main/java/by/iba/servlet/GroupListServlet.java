package by.iba.servlet;

import by.iba.model.ListService;
import by.iba.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GroupListServlet", value = "/GroupListServlet")
public class GroupListServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    private ListService todoService = new ListService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("group", ListService.retrieveList());
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                .forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nname = request.getParameter("nname");
        String nphone = request.getParameter("nphone");
        String nemail = request.getParameter("nemail");
        if (("".equals(nname)) || ("".equals(nphone)) || ("".equals(nemail))) {
            request.setAttribute("errorMessage", "Заполните все поля");
        } else {
            ListService.addPerson(new Person(nname, nphone, nemail));
        }
        request.setAttribute("group", ListService.retrieveList());
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);

    }

}
