<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Трудоустройства</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 80%; }
        th, td { padding: 10px; border: 1px solid #ccc; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2>Трудоустройства</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Работник</th>
        <th>Вакансия</th>
        <th>Дата открытия</th>
        <th>Дата закрытия</th>
    </tr>

    <c:forEach var="em" items="${employments}">
        <tr>
            <td>${em.id}</td>
            <td>${em.workerId}</td>
            <td>${em.vacancyId}</td>
            <td>${em.date_open}</td>
            <td>${em.date_closed}</td>
            <td>
                <form method="post" action="employment" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${em.id}"/>
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Добавить трудоустройство</h3>
<form method="post" action="employment">
    <input type="hidden" name="action" value="add"/>
    <input type="text" name="workerId" placeholder="ID работника" required/>
    <input type="text" name="vacancyId" placeholder="ID вакансии" required/>
    <input type="date" name="date_open" required/>
    <input type="date" name="date_closed"/>
    <button type="submit">Добавить</button>
</form>
</body>
</html>
