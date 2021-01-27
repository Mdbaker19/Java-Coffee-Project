<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/22/21
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coffee page</title>
    <style><%@ include file="../CSS/coffeeStyle.css" %></style>
    <style><%@ include file="../CSS/globalStyle.css" %></style>
</head>
<body>
    <%@ include file="../partials/navBar.jsp" %>

    <div id="coffeeArea">
        <c:forEach var="coffee" items="${coffeeList}">
            <div id="eachCoffee">
                <h1>${coffee.name}</h1>
                <div id="coffeeInfo">
                    <p>${coffee.type}</p><p>${coffee.price}</p>
                </div>
            </div>
        </c:forEach>
    </div>

    <button id="jsTest">Console Log Click</button>

<script src="../JS/test.js"></script>
</body>
</html>
