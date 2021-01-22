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
</head>
<body>

    <form action="/coffee" method="POST">
        <input name="choice">
        <button type="submit">Submit</button>
    </form>

</body>
</html>
