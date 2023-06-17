<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <%@include file="header.jspf"%>
  <div class="container" >
   <div class="container" >
       Your Tasks are
   </div>

        <table class="table">
            <thead>
               <th>ID</th>
               <th>Description</th>
               <th>Date</th>
               <th>Status</th>
               <th>User</th>
            </thead>
            <tbody>
              <c:forEach items="${todosList}" var="todo">
                <tr>
                    <td> ${todo.id}</td>
                    <td> ${todo.description}</td>
                    <td> ${todo.todoDate}</td>
                    <td> ${todo.status}</td>
                    <td> ${todo.userName}</td>
                    <td><a href="/todo/edit/${todo.id}" class="btn btn-warning"> Update </a></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
       <a href="todos/add" class="btn btn-success"> Add Todo</a>
  </div>

</body>
</html>