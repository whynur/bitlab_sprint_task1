package kz.bitlab.javaee.sprint.db;

import kz.bitlab.javaee.sprint.kz.bitlab.javaee.sprint.model.Tasks;

import java.util.ArrayList;

public class DBManager {
    static ArrayList<Tasks> tasks = new ArrayList<>();
    private static Long id = 6L;
    static{
        tasks.add(
                new Tasks(1L,
                "Создать Веб приложение на JAVA EE",
                "abc",
                "2021-10-21")
        );
        tasks.add(
                new Tasks(2L,
                "Убраться дома и закупить продукты",
                "abcd",
                "2021-10-25")
        );
        tasks.add(
                new Tasks(3L,
                        "Выполнить все домашние дела",
                        "abcb",
                        "2021-10-28")
        );
        tasks.add(
                new Tasks(4L,
                        "Записаться на качку",
                        "abce",
                        "2021-12-12")
        );
        tasks.add(
                new Tasks(5L,
                        "Учить Итальянский",
                        "abcf",
                        "2021-05-01")
        );

    }

    public static void addTask(Tasks task){
        task.setId(id);
        id++;
        tasks.add(task);
    }

    public static Tasks getTask(Long id){
        for (Tasks t: tasks){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    public static ArrayList getAllTasks(){
        return tasks;
    }

    public static void deleteTask(Long id){
        for (Tasks t: tasks){
            if(t.getId()==id){
                tasks.remove(t);
            }
        }
    }

    public static void upDateTasks(ArrayList<Tasks> updTasks){
        tasks = updTasks;
    }
}
