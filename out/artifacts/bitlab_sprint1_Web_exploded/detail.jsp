<%@ page import="kz.bitlab.javaee.sprint.kz.bitlab.javaee.sprint.model.Tasks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Детали</title>
    <%@include file="head.jsp"%>
</head>
<body>
<div style="width: 95%; margin-left: auto; margin-right: auto">
    <%@include file="header.jsp"%>
    <form action="/details" method="post" style="width: 50%; margin-left: auto; margin-right: auto; margin-top: 30px">
        <%
            Tasks task = (Tasks) request.getSession().getAttribute("task");


        %>
        <div class="form-group" style="margin-top: 20px">
            <label for="exampleInputEmail1">Наименование: </label>
            <input type="text" class="form-control" id="exampleInputEmail1" name = "name" value="<%=task.getName()%>">

        </div>
        <div class="form-group" style="margin-top: 20px">
            <label for="exampleFormControlTextarea1">Описание: </label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="3"><%=task.getDescription()%></textarea>
        </div>
        <div class="form-group" style="margin-top: 20px">
            <label for="exampleInputEmail1">Крайний срок: </label>
            <input type="date" class="form-control" name="deadlineDate" value="<%=task.getDeadlineDate()%>">

        </div>

        <div class="form-group" style="margin-top: 20px">
            <label for="exampleFormControlSelect1">Выполнено:</label>
            <select class="form-control" id="exampleFormControlSelect1" name="done">
                <option value="true">Да</option>
                <option value="false">Нет</option>
            </select>
        </div>
        <button class="btn btn-success" style="margin-top: 15px">Сохранить</button>

    </form>
    <form action="/detailDelete" method="post">
        <input type="hidden" name="id" value="<%=task.getId()%>">
        <button class="btn btn-danger" style="position: absolute;left: 34%; top: 456px;">Удалить</button>
    </form>
</div>
</body>
</html>
