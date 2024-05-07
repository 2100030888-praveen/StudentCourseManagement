<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
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
    <h1>Edit Student</h1>

    <form action="updatestudent" method="post" id="studentForm">
        <input type="hidden" name="id" value="${student.id}" />

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}" />

        <label for="gender">Gender:</label>
        
		<select name="gender" required>
            <option value="${student.gender}">${student.gender}</option>
            
                <option value="MALE">MALE</option>
                <option value="FEMALE">FEMALE</option>
                
            
        </select>
		
		
        <label for="dateofbirth">Date of Birth:</label>
        <input type="date" id="dateofbirth" name="dateofbirth" value="${student.dateofbirth}" />

        <label for="department">Department:</label>
        <input type="hidden" id="department" name="department" value="${student.department}" readonly="readonly"/>
        <input type="text" id="department1" name="department1" value="${departmentname}" readonly="readonly"/>
	    
        <label for="year">Year:</label>
        
		
		<select name="year" required>
            <option value="${student.year}">${student.year}</option>
            
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            
        </select>
		
		
		
        <label for="sem">Semester:</label>
      

		<select name="sem" required>
            <option value="${student.sem}">${student.sem}</option>
            
                <option value="1">1</option>
                <option value="2">2</option>

            
        </select>
		
		
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${student.email}" readonly="readonly"/>

        <label for="password">Password:</label>
        <input type="text" id="password" name="password" value="${student.password}" />

        <label for="contact">Contact:</label>
        <input type="number" id="contact" name="contact" value="${student.contact}" />

        <input type="submit" value="Update Student" onclick="return confirmUpdate();" />
    </form>

    <a href="viewallstudents">Back to Students</a>
</body>
<script>
function confirmUpdate() {
    var confirmation = confirm("Are you sure you want to update this student?");
    
    // Return true to allow the form submission if the user confirms
    return confirmation;
}
</script>
</html>
