<%@ page isErrorPage="true" %>    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<h1>Edit Task</h1>
<form:form action="/tasks/${task.id}" method="post" modelAttribute="task">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Task: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>

    <p>
        <form:label path="priority">Priority: </form:label>
        <form:errors path="priority"/>
        <form:input path="priority"/>
    </p>
   

    <input type="submit" value="Update"/>

</form:form>