<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<h1><c:out value="${task.name}"/></h1>

<p>Creator: <c:out value="${task.user.email}"/></p>

<p>Priority: <c:out value="${task.priority}"/></p>


<a href="/tasks/${task.id}/edit">Edit Task</a>

<form action="/tasks/${task.id}" method="post">

    <input type="hidden" name="_method" value="delete">

    <input type="submit" value="Delete">

</form>