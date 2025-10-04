<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Список вакансий</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    table { border-collapse: collapse; width: 80%; }
    th, td { padding: 10px; border: 1px solid #ccc; }
    th { background-color: #f2f2f2; }
    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 5px;
      box-sizing: border-box;
    }
    button { padding: 5px 10px; }
  </style>
</head>
<body>
<h2>Список вакансий</h2>
<table>
  <tr>
    <th>ID</th>
    <th>ID Работодателя</th>
    <th>Зарплата</th>
    <th>Должность</th>
    <th>Описание</th>
    <th>Действия</th>
  </tr>
  <c:forEach var="v" items="${vacancies}">
    <form method="post" action="vacancy">
      <tr>
        <td>${v.id}
          <input type="hidden" name="id" value="${v.id}"/>
        </td>
        <td>${v.employerId}
          <input type="hidden" name="employerId" value="${v.employerId}"/>
        </td>

        <td>
          <input type="number" name="salary" value="${v.salary}" required/>
        </td>
        <td>
          <input type="text" name="post" value="${v.post}" required/>
        </td>
        <td>
          <input type="text" name="description" value="${v.description}" required/>
        </td>
        <td>
          <button type="submit" name="action" value="update">Сохранить</button>
          <button type="submit" name="action" value="delete">Удалить</button>
        </td>
      </tr>
    </form>
  </c:forEach>

</table>

<h3>Добавить вакансию</h3>
<form method="post" action="vacancy">
  <input type="hidden" name="action" value="add"/>
  <label>
    Зарплата: <input type="number" name="salary" placeholder="Введите зарплату" required/>
  </label><br><br>
  <label>
    Должность: <input type="text" name="post" placeholder="Введите должность" required/>
  </label><br><br>
  <label>
    Описание: <input type="text" name="description" placeholder="Введите описание" required/>
  </label><br><br>
  <label>
    ID работодателя: <input type="text" name="employerId" placeholder="Введите ID работодателя" required/>
  </label><br><br>
  <button type="submit">Добавить</button>
</form>
</body>
</html>
