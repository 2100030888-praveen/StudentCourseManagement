<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Faculty</title>
    <!-- Include your CSS and JavaScript links here if needed -->
<style>
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
  width: 100%;
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
<h1>Edit Faculty</h1>

<form action="updatefaculty" method="post" id="facultyForm">
    <input type="hidden" name="id" value="${faculty.id}" />

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${faculty.name}" />

    <label for="gender">Gender:</label>
    <select name="gender" required>
        <option value="${faculty.gender}">${faculty.gender}</option>
        <option value="MALE">MALE</option>
        <option value="FEMALE">FEMALE</option>
    </select>

    <label for="dateofbirth">Date of Birth:</label>
    <input type="date" id="dateofbirth" name="dateofbirth" value="${faculty.dateofbirth}" />

    <!-- You may need to modify this part for department selection based on your data model -->
    <label for="department">Department:</label>
    <input type="hidden" id="department" name="department" value="${faculty.department_id}" readonly="readonly" />
    <input type="text" id="department1" name="department1" value="${departmentname}" readonly="readonly" />

    <label for="salary">Salary:</label>
    <input type="text" id="salary" name="salary" value="${faculty.salary}" />

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${faculty.email}" readonly="readonly" />

    <label for="password">Password:</label>
    <input type="text" id="password" name="password" value="${faculty.password}" />

    <label for="location">Location:</label>
    <input type="text" id="location" name="location" value="${faculty.location}" />

    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact" value="${faculty.contact}" />

    <label for="ishod">Is HOD:</label>
    <input type="checkbox" id="ishod" name="ishod" ${faculty.ishod ? 'checked' : ''} />

    <label for="iscc">Is CC:</label>
    <input type="checkbox" id="iscc" name="iscc" ${faculty.iscc ? 'checked' : ''} />

    <input type="submit" value="Update Faculty" onclick="return confirmUpdate();" />
</form>

<a href="viewallfaculties">Back to Faculties</a>

<script>
function confirmUpdate() {
    var confirmation = confirm("Are you sure you want to update this faculty?");
    // Return true to allow the form submission if the user confirms
    return confirmation;
}
</script>
</body>
</html>
