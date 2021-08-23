<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<h1>New Task</h1>
<form:form action="/tasks" method="post" modelAttribute="task">
    <p>
        <form:label path="name">Task:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>

    <p>
        <form:label path="priority">Priority</form:label>
        <form:errors path="priority"/>
        <form:input path="priority"/>
    </p>
    
    <form:label path="priority">Priority</form:label>
    
  
    <input type="submit" value="Submit"/>
    
</form:form>
