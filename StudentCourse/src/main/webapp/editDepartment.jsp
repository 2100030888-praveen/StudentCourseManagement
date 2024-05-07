<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
    <title>Edit Department</title>
    <!-- Include your CSS and JavaScript links here if needed -->
    <style>
    body{
    background:linear-gradient(to right, #bab7b7, #4b4849);
  }
  .button {
  background-color: black;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

input[type=text],input[type=password],input[type=number],input[type=email],
select,input[type=date],input[type=datetime-local]
{
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label 
{
  padding: 12px 12px 12px 0;
  display: inline-block;
  font-weight: bold;
}

input[readonly] 
{
            background-color: #f0f0f0; /* Gray background color */
            color: #555; /* Gray text color */
            cursor: not-allowed; /* Change cursor to indicate it's not editable */
}
    </style>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<center>
    <h1>Edit Department</h1>

    <form action="updateDepartment" method="post">
        <input type="hidden" name="department_id" value="${department.department_id}" />

        <label for="department_name">Department Name:</label>
        <input type="text" id="name" name="department_name" value="${department.department_name}" />

        <!-- Add more input fields for other department details as needed -->
<br>

        <input type="submit" value="Update Department" />
    </form>

    <a href="viewalldept">Back to Departments</a>
    </center>
</body>
</html>
