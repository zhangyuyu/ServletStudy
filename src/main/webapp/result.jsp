<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>result</title>
    </head>
    <body>
     Name:<%= request.getParameter("name") %></br>
     Sex:<%= request.getParameter("sex") %></br>
     Age:<%= request.getParameter("age") %></br>
     Birthday:<%= request.getParameter("birthday") %>

     <table>
        <tr>
            <td>Name</td>
            <td>Sex</td>
            <td>Age</td>
            <td>Birthday</td>
        </tr>
        <c:forEach var="item" items="${customerList}">
            <tr>
                    <td>${item.getName()}</td>
                    <td>${item.getSex()}</td>
                    <td>${item.getAge()}</td>
                    <td>${item.getBirthday()}</td>
            </tr>
         </c:forEach>
     </table>

    </body>
</html>