<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 25-10-2023
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservations</title>
</head>
<body>
    <ul>
        <c:forEach items="${reservations}" var="reservation">
            <li>uuid: ${reservation.uuid}</li>
            <li>date: ${reservation.date}</li>
            <li>status: ${reservation.status}</li>
            <li>seats number: ${reservation.seatsNumber}</li>
            <li>flight uuid: ${reservation.flight.uuid}</li>
            <li>client uuid: ${reservation.client.uuid}</li>
            <li>=======================</li>
        </c:forEach>
    </ul>
</body>
</html>
