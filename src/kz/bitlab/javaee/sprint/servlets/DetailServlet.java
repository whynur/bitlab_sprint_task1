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

@WebServlet(value = "/details")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Tasks task = DBManager.getTask(id);
        if(task!=null){
            request.getSession().setAttribute("task", task);
            request.getRequestDispatcher("detail.jsp").forward(request,response);
        }
        else request.getRequestDispatcher("404.jsp").forward(request,response);;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        Tasks task = (Tasks) request.getSession().getAttribute("task");
        task.setDone(Boolean.parseBoolean(request.getParameter("done")));
        task.setDescription((String) request.getParameter("description"));
        task.setName((String) request.getParameter("name"));
        task.setDeadlineDate((String) request.getParameter("deadlineDate"));
        for (int i =0; i<tasks.size();i++){
            if(tasks.get(i).getId()==task.getId()){
                tasks.set(i,task);
            }
        }
        DBManager.upDateTasks(tasks);
        response.sendRedirect("/index");
    }
}
