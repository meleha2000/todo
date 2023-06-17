<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
</head>
<body>
<%@include file="header.jspf"%>
<div class="container" >
    <div class="container" >
        <h1>Enter task</h1>
    </div>
     <form:form method="post" modelAttribute="user" action="/users/save" >
    <div class="form-group ">
         <label class="title" for="userName" title="Description: ">User Name: </label>
          <form:input class="form-control"  type="text" id="userName" path="userName"/>
        <form:errors class="alert-danger" path="userName"/>
    </div>

    <div class="form-group">
             <label for="password" title="Date: ">password: </label>
             <form:input  class="form-control" type="text" id="password"  path="password"/>
    </div>

    <div class="form-group">
             <label for="roleName" title="User Name: ">Role Name: </label>
             <form:input  class="form-control" type="text" id="roleName" path="roleName"/>
    </div>



    <div class="form-group">

        <input id="b1" label="Submit" type="submit"  class="btn btn-success"   />

    </div>

     </form:form>


</div>

</body>
</html>