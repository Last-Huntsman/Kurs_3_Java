<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Трудоустройства</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 90%; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
        th { background-color: #f2f2f2; }
        form { display: inline; }
        button { padding: 5px 10px; margin: 2px; cursor: pointer; border-radius: 6px; }
        button.close { background-color: #ffcccc; }
        button.open { background-color: #ccffcc; }
        button.delete { background-color: #eeeeee; }
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
        <th>Действия</th>
    </tr>

    <jsp:useBean id="employments" scope="request" type="java.util.List"/>
    <c:forEach var="em" items="${employments}">
        <tr>
            <td>${em.id}</td>
            <td>${em.workerId}</td>
            <td>${em.vacancyId}</td>
            <td>${em.date_open}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty em.date_closed}">
                        ${em.date_closed}
                    </c:when>
                    <c:otherwise>
                        <span style="color: green;">Открыта</span>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <!-- если вакансия открыта — показываем кнопку "Закрыть" -->
                <c:if test="${empty em.date_closed}">
                    <form method="post" action="employment">
                        <input type="hidden" name="action" value="close"/>
                        <input type="hidden" name="id" value="${em.id}"/>
                        <input type="hidden" name="workerId" value="${em.workerId}"/>
                        <input type="hidden" name="vacancyId" value="${em.vacancyId}"/>
                        <input type="hidden" name="date_open" value="${em.date_open}"/>
                        <button type="submit" class="close">Закрыть</button>
                    </form>
                </c:if>

                <!-- если вакансия закрыта — показываем кнопку "Открыть" -->
                <c:if test="${not empty em.date_closed}">
                    <form method="post" action="employment">
                        <input type="hidden" name="action" value="open"/>
                        <input type="hidden" name="id" value="${em.id}"/>
                        <input type="hidden" name="workerId" value="${em.workerId}"/>
                        <input type="hidden" name="vacancyId" value="${em.vacancyId}"/>
                        <button type="submit" class="open">Открыть</button>
                    </form>
                </c:if>

                <!-- кнопка удаления -->
                <form method="post" action="employment">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${em.id}"/>
                    <button type="submit" class="delete">Удалить</button>
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
    <button type="submit">Добавить</button>
</form>

</body>
</html>
