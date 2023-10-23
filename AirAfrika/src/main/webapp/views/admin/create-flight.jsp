<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Create Flight</title>
    <link
      rel="stylesheet"
      href="<%= request.getContextPath() %>/resources/style/style.css"
    />
  </head>
  <body>
    <div class="flight-form-background">
      <div class="flight-form-wrapper">
        <div class="form-content">
          <h1>Create Flight</h1>
          <form action="<%=request.getContextPath()%>/flight?action=create" method="post">
            <c:if test="${data eq false}">
              <p class="invalid-data">Invalid data</p>
            </c:if>
            <div class="input-group">
              <label>Flight Departure City</label>
              <input
                  type="text"
                  name="departure-city"
                  placeholder="Enter Departure City "
              />
            </div>
            <div class="input-group">
              <label>Flight Arrival City</label>
              <input
                  type="text"
                  name="arrival-city"
                  placeholder="Enter Arrival City"
              />
            </div>
            <div class="input-group">
              <label>Flight Departure Date</label>
              <input
                  type="date"
                  name="departure-date"
                  placeholder="Enter Departure Date"
              />
            </div>
            <div class="input-group">
              <label>Flight Arrival Date</label>
              <input
                  type="date"
                  name="arrival-date"
                  placeholder="Enter Arrival Date"
              />
            </div>
            <div class="input-group">
              <label>Flight Departure Time</label>
              <input
                  type="time"
                  name="departure-time"
                  placeholder="Enter Departure Time"
              />
            </div>
            <div class="input-group">
              <label>Flight Arrival Time</label>
              <input
                  type="time"
                  name="arrival-time"
                  placeholder="Enter Arrival Time"
              />
            </div>
            <div class="input-group">
              <label>Flight Seats Number</label>
              <input
                  type="number"
                  name="seats-number"
                  placeholder="Enter Seats Number"
              />
            </div>
            <div class="input-group">
              <label>Flight Price</label>
              <input type="number" name="price" placeholder="Enter Price" />
            </div>
            <div class="input-group">
              <label>Flight Description</label>
              <textarea
                  name="description"
                  placeholder="Enter Description"
              ></textarea>
            </div>
            <button class="submit">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
