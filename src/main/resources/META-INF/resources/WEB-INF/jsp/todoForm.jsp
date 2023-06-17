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
     <form:form method="post" modelAttribute="todo" action="/todos/save" >
    <div class="form-group ">
         <label class="title" for="description" title="Description: ">Description: </label>
          <form:input class="form-control"  type="text" id="description" path="description"/>
        <form:errors class="alert-danger" path="description"/>
    </div>

    <div class="form-group">
             <label for="description" title="Date: ">Date: </label>
             <form:input  class="form-control" type="text" id="todoDate"  path="todoDate"/>
    </div>

    <div class="form-group">
             <label for="userName" title="User Name: ">User Name: </label>
             <form:input  class="form-control" type="text" id="userName" path="userName"/>
    </div>

    <div class="form-group">
             <label for="status" title="status: ">status: </label>
             <form:input class="form-control" type="text" id="status" path="status"/>
    </div>

    <div class="form-group">

        <input id="b1" label="Submit" type="submit"  class="btn btn-success"   />

    </div>

     </form:form>


</div>

</body>
</html>