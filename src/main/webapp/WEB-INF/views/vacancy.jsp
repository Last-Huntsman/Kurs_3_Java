<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Список вакансий</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    table { border-collapse: collapse; width: 80%; }
    th, td { padding: 10px; border: 1px solid #ccc; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>
<h2>Список вакансий</h2>
<table>
  <tr>
    <th>ID</th>
    <th>Компания</th>
    <th>Зарплата</th>
    <th>Должность</th>
    <th>Описание</th>
  </tr>

  <c:forEach var="v" items="${vacancies}">
    <tr>
      <td>${v.id}</td>
      <td>${v.employerId}</td>
      <td>
        <form method="post" action="vacancy" style="display:inline;">
          <input type="hidden" name="action" value="update"/>
          <input type="hidden" name="id" value="${v.id}"/>
          <input type="number" name="salary" value="${v.salary}" required/>
          <input type="text" name="post" value="${v.post}" required/>
          <input type="text" name="description" value="${v.description}" required/>
          <button type="submit">Сохранить</button>
        </form>
      </td>
      <td>
        <form method="post" action="vacancy" style="display:inline;">
          <input type="hidden" name="action" value="delete"/>
          <input type="hidden" name="id" value="${v.id}"/>
          <button type="submit">Удалить</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

<h3>Добавить вакансию</h3>
<form method="post" action="vacancy">
  <input type="hidden" name="action" value="add"/>
  <input type="text" name="post" placeholder="Должность" required/>
  <input type="number" name="salary" placeholder="Зарплата" required/>
  <input type="text" name="description" placeholder="Описание" required/>
  <input type="text" name="employerId" placeholder="ID компании" required/>
  <button type="submit">Добавить</button>
</form>
</body>
</html>
