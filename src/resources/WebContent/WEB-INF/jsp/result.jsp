<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 03.03.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Here is result</title>
</head>
<body>
    <h2>Submitted user information</h2>
    <table>
        <tr>
            <td>Name</td>
            <td>#{name}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td>#{password}</td>
        </tr>
        <tr>
            <td>ID</td>
            <td>#{userID}</td>
        </tr>
    </table>
</body>
</html>
