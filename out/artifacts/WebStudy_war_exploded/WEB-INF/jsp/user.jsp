<?xml version="1.0" encoding="ISO-8859-1"?>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
    <head>
        <title>Trying to learn some Spring MVC</title>
    </head>

    <body>
        <h2>User Information</h2>
    <form:form method="post" action="/controllers/addUser">
        <table>
            <tr>
                <td><form:label path="userName">Name</form:label></td>
                <td><form:input path="userName"/></td>
            </tr>
            <tr>
                <td><form:label path="password">password</form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><form:label path="id">ID</form:label></td>
                <td><form:input path="id"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type = "submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>
    </body>
</html>


    <!-- Invoke 'Generate' action to add tags or functions -->

</taglib>
