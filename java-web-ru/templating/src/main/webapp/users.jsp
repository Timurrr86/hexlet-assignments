<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
        // Подключаем стили Bootstrap
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        // В цикле выводим все компании
        // Внутри jsp-файла нам доступна переменная companies, которую мы установили в сервлете
        <c:forEach var="company" items="${companies}">
            <tr>
            <td>${company.get("id")}</td>
            <td><a href='/companies/show?id=${company.get("id")}'>${company.get("name")}</a></td>
            </tr>
        </c:forEach>
    </body>
</html>
<!-- END -->
