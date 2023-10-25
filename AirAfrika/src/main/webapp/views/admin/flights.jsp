<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Flights List</title>
  </head>
  <body>
    <h1>List of all flights</h1>
    <p>,fskld,fnls</p>
    <a href="<%= request.getContextPath() %>/flight?action=create">Create Flight</a>
    <br>
    <table border="1">
      <tr>
        <th>departure_city</th>
        <th>arrival_city</th>
        <th>departure_date</th>
        <th>arrival_date</th>
        <th>departure_time</th>
        <th>arrival_time</th>
        <th>seats_number</th>
        <th>price</th>
        <th>description</th>
        <th>operations</th>
      </tr>
      <c:forEach items="${flights}" var="flight">
        <tr>
          <td>${flight.departureCity}</td>
          <td>${flight.arrivalCity}</td>
          <td>${flight.departureDate}</td>
          <td>${flight.arrivalDate}</td>
          <td>${flight.departureTime}</td>
          <td>${flight.arrivalTime}</td>
          <td>${flight.seatsNumber}</td>
          <td>${flight.price}</td>
          <td>${flight.description}</td>
          <td>
            <button><a href="<%= request.getContextPath()%>/flight?action=update&uuid=${flight.uuid}">update</a></button>
            <form action="<%= request.getContextPath()%>/flight?action=delete" method="post">
              <input type="hidden" name="uuid" value="${flight.uuid}">
              <input type="submit" value="delete">
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
