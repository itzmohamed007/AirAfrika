<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Search Flight</title>
    <link
      rel="stylesheet"
      href="<%= request.getContextPath() %>/resources/style/style.css"
    />
  </head>
  <body>
    <div class="reservation-form-background">
      <div class="reservation-form-wrapper">
        <div class="form-content">
          <h1>Search Flight</h1>
          <form
            action="<%=request.getContextPath()%>/flight?action=search"
            method="post"
          >
            <c:if test="${data eq false}">
              <p class="invalid-data">Invalid data</p>
            </c:if>
            <div class="input-group">
              <label>Departure City</label>
              <input
                type="text"
                name="departure-city"
                placeholder="Enter Departure City "
              />
            </div>
            <div class="input-group">
              <label>Arrival City</label>
              <input
                type="text"
                name="arrival-city"
                placeholder="Enter Arrival City"
              />
            </div>
            <div class="input-group">
              <label>Departure Date</label>
              <input
                type="date"
                name="departure-date"
                placeholder="Enter Departure Date"
              />
            </div>
            <div class="input-group">
              <label>Arrival Date</label>
              <input
                type="date"
                name="arrival-date"
                placeholder="Enter Arrival Date"
              />
            </div>
            <div class="submit-wrapper">
              <button class="submit">Search</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
