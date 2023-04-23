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

@WebServlet(value = "/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addTask.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tasks task = new Tasks();
        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        task.setDone(false);
        task.setDescription((String) request.getParameter("description"));
        task.setName((String) request.getParameter("name"));
        task.setDeadlineDate((String) request.getParameter("deadlineDate"));
        DBManager.addTask(task);
        response.sendRedirect("/index");
    }
}