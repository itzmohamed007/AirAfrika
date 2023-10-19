<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17-10-2023
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights List</title>
</head>
<body>
<h1>List of all flights</h1>
<table border="1">
    <tr>
        <th>uuid</th>
        <th>departure_city</th>
        <th>arrival_city</th>
        <th>departure_date</th>
        <th>arrival_date</th>
        <th>departure_time</th>
        <th>arrival_time</th>
        <th>seats_number</th>
        <th>price</th>
        <th>description</th>
    </tr>
    <c:forEach items="${flights}" var="flight">
        <tr>
            <td>${flight.uuid}</td>
            <td>${flight.departureCity}</td>
            <td>${flight.arrivalCity}</td>
            <td>${flight.departureDate}</td>
            <td>${flight.arrivalDate}</td>
            <td>${flight.departureTime}</td>
            <td>${flight.arrivalTime}</td>
            <td>${flight.seatsNumber}</td>
            <td>${flight.price}</td>
            <td>${flight.description}</td>
        </tr>
        <h1>${flight.uuid}</h1>
    </c:forEach>
</table>

</body>
</html>
