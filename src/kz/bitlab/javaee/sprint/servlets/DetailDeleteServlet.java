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

@WebServlet(value = "/detailDelete")
public class DetailDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
//        DBManager.deleteTask(id); ошибка 500 выходит, из за этого я не использовал это
        ArrayList<Tasks> tasks = DBManager.getAllTasks();
        ArrayList<Tasks> updTasks = new ArrayList<>();
        for(Tasks t: tasks){
            if(t.getId()!=id){
                updTasks.add(t);
            }
        }
        DBManager.upDateTasks(updTasks);
        response.sendRedirect("/index");
    }
}
