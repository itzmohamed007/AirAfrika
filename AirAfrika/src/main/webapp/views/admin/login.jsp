<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Admin Login</title>
    <link
      rel="stylesheet"
      href="<%= request.getContextPath() %>/resources/style/style.css"
    />
  </head>
  <body>
    <div class="login-background">
      <div class="login-form-wrapper">
        <form action="<%=request.getContextPath()%>/login" method="post">
          <h1>Login</h1>
          <c:if test="${credentials eq false}">
            <p class="wrong-credentials">Wrong credentials</p>
          </c:if>
          <div class="input-group">
            <label>Enter Email</label>
            <input type="email" name="email" placeholder="Enter Email" />
          </div>
          <div class="input-group">
            <label>Enter Password</label>
            <input
              type="password"
              name="password"
              placeholder="Enter Password"
            />
          </div>
          <button class="submit">Submit</button>
        </form>
      </div>
    </div>
  </body>
</html>
