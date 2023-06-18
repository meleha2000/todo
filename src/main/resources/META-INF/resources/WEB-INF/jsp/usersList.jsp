<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>
  <%@include file="header.jspf"%>
  <div class="container" >
   <div class="container" >
      Users List
   </div>

        <table class="table">
            <thead>
               <th>ID</th>
               <th>user Name</th>
               <th>Password</th>
               <th>Role</th>
            </thead>
            <tbody>
              <c:forEach items="${usersList}" var="user">
                <tr>
                    <td> ${user.id}</td>
                    <td> ${user.userName}</td>
                    <td> ${user.password}</td>
                    <td> ${user.roleName}</td>

                    <td><a href="/user/edit/${user.id}" class="btn btn-warning"> Update </a></td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
       <a href="/users/add" class="btn btn-success"> Add User</a>
  </div>

</body>
</html>