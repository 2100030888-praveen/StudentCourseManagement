<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Announcement</title>
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

<h3 align=center  style="color:green">${message}</h3>
<center>
    <h1>Add Announcement</h1>
    
    <form action="addannouncement1" method="post">
        <label for="announcement">Announcement:</label>
        <textarea id="announcement" name="announcement" rows="4" cols="50" required></textarea>
<br>
        <label>Announcement for selected department:</label>
        <c:if test="${dept==0 }">
        <input type="text" name="dept" value="${dept}" readonly="readonly">
        </c:if>
<input type="text" name="dept" value="${dept}" readonly="readonly">
<br>
<br>
   <label for="selectedDateTime">Select Date and Time:</label>
        <input type="datetime-local" id="selectedDateTime" name="startDateTime" required />
   <br>
   <label for="selectedDateTime">Select Date and Time:</label>
        <input type="datetime-local" id="selectedDateTime" name="endDateTime" required />
<br>
   
   <label>For</label>

        <select name="who" required>
            <option value="both">Student && Faculty</option>
                <option value="student">Students</option>
                <option value="faculty">Faculty</option>
            
        </select>

<br>
        <input type="submit" value="Add" class="button">
    </form>
</center>
    <a href="viewAnnouncements">View Announcements</a>
</body>
</html>
