package kz.bitlab.javaee.sprint.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.javaee.sprint.db.DBManager;
import kz.bitlab.javaee.sprint.kz.bitlab.javaee.sprint.model.Tasks;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet(value = "/index")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        request.setAttribute("tasks", tasks);
        boolean checkAddButton = true;
        request.setAttribute("checkAddButton", checkAddButton);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
