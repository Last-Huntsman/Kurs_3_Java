<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список работников</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 70%; }
        th, td { padding: 10px; border: 1px solid #ccc; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2>Список работников</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
    </tr>

    <c:forEach var="w" items="${workers}">
        <tr>
            <td>${w.id}</td>
            <td>
                <form method="post" action="worker" style="display:inline;">
                    <input type="hidden" name="action" value="update"/>
                    <input type="hidden" name="id" value="${w.id}"/>
                    <input type="text" name="name" value="${w.name}" required/>
                    <button type="submit">Сохранить</button>
                </form>
            </td>
            <td>
                <form method="post" action="worker" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${w.id}"/>
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Добавить работника</h3>
<form method="post" action="worker">
    <input type="hidden" name="action" value="add"/>
    <input type="text" name="name" placeholder="Введите имя" required/>
    <button type="submit">Добавить</button>
</form>
</body>
</html>
