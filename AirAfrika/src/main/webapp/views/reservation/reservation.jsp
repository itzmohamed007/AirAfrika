<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 25-10-2023
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
</head>
<body>
  <h1>Reservation: </h1>
  <p>date: ${reservation.date}</p>
  <p>status: ${reservation.status}</p>
  <p>seats number: ${reservation.seatsNumber}</p>
  <p>flight uuid: ${reservation.flight.uuid}</p>
  <p>client uuid: ${reservation.client.uuid}</p>
</body>
</html>
