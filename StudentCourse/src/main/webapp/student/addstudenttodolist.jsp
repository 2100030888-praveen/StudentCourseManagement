<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Task Form</title>
</head>
<body>

<h2>Todo Task Form</h2>

<form action="addstudenttodolist" method="post">
   
   <label for="studentId"></label>
    <input type="hidden" value="${sid}" id="studentId" name="studentId" required><br>
   
    <label for="todoTask">Todo Task:</label>
    <input type="text" id="todoTask" name="todoTask" required><br>

    <label for="dueDate">Due Date:</label>
    <input type="datetime-local" id="dueDate" name="dueDate" required><br>

    <label for="todoStatus">Todo Status:</label>
    <select id="todoStatus" name="todoStatus" required>
        <option value="true">Completed</option>
        <option value="false">Not Completed</option>
    </select><br>

    <button type="submit">Submit</button>
</form>

</body>
</html>