<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Список компаний</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 50%; }
        th, td { padding: 10px; border: 1px solid #ccc; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2>Список компаний</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
    </tr>

    <c:forEach var="e" items="${employers}">
        <tr>
            <td>${e.id}</td>
            <td>
                <form method="post" action="employer" style="display:inline;">
                    <input type="hidden" name="action" value="update"/>
                    <input type="hidden" name="id" value="${e.id}"/>
                    <label>
                        <input type="text" name="name" value="${e.name}" required/>
                    </label>
                    <button type="submit">Сохранить</button>
                </form>
            </td>
            <td>
                <form method="post" action="employer" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${e.id}"/>
                    <button type="submit">Удалить</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<h3>Добавить компанию</h3>
<form method="post" action="employer">
    <input type="hidden" name="action" value="add"/>
    <label>
        <input type="text" name="name" placeholder="Введите имя" required/>
    </label>
    <button type="submit">Добавить</button>
</form>
</body>
</html>
