<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 24.02.2022
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inna forma</title>
</head>
<body>
<form action="/radio" method="get">>
    Wybierz formę płatności:
    <input type="radio" name="payment" value="card" checked/>Karta kredytowa
    <input type="radio" name="payment" value="cash"/>Gotówka
    <input type="radio" name="payment" value="transfer"/>Przelew
    <input type="submit" name="wybór trx" value="Wybierz rozdzaj transakcji">
</body>
</html>
