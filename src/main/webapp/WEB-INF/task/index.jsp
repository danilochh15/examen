<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>All Task</h1>
<table>
<h1>Welcome, <c:out value="${user.email}" /></h1>
    <thead>
        <tr>
            <th>Task</th>
            <th>Creator</th>
            <th>Priority</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${tasks}" var="task">
        <tr>
            <td>
            	<a href="/tasks/${task.id}">${task.name}</a>
            </td>
            <td><c:out value="${task.user.email}"/></td>
            <td><c:out value="${task.priority}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/tasks/new">New Task</a>