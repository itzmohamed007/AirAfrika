<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17-10-2023
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Here is your flight</title>
</head>
<body>
    <p>${flight.uuid}</p>
    <p>${flight.departureCity}</p>
    <p>${flight.arrivalCity}</p>
    <p>${flight.departureDate}</p>
    <p>${flight.arrivalDate}</p>
    <p>${flight.departureTime}</p>
    <p>${flight.arrivalTime}</p>
    <p>${flight.seatsNumber}</p>
    <p>${flight.price}</p>
    <p>${flight.description}</p>
</body>
</html>
