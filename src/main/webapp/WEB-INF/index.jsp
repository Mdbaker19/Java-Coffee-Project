<%--
  Created by IntelliJ IDEA.
  User: matthewbaker
  Date: 1/22/21
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a coffee</title>
    <style><%@ include file="../CSS/inputStyle.css" %></style>
    <style><%@ include file="../CSS/globalStyle.css" %></style>
</head>
<body>

    <%@ include file="/WEB-INF/partials/navBar.jsp" %>


    <form id="mainForm" action="/coffee" method="POST">
        <label>
            Coffee Name
            <input name="choice">
        </label>
        <label>
            Coffee Type
            <input name="type">
        </label>
        <label>
            Coffee Price
            <input name="cost">
        </label>
        <button type="submit">Submit</button>
    </form>

</body>
</html>
