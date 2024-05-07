
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
       <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Navbar</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="path-to-your-boxicons-css-file.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'></link>
    <link rel="stylesheet" href="path-to-font-awesome-css-file.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link type="text/css" rel="stylesheet" href="css/adminnav.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<nav>

   <button id="myButton" style="background-color: #333;width: 84px;height: 84px;top:-4px;"><img src="images/logo.png" class="hello" ></button>
  <ul>
    <li><a href="adminhome" class="jello-horizontal"><i class="fas fa-home"></i >Home</a></li>
    <li><a href="#" class="jello-horizontal"><i class="fas fa-landmark"></i>Departments</a>
      <ul>
        <li><a href="adddept">Add/Delete &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
        <li><a href="viewalldept">View/Update &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
      </ul>
    </li>
    <li><a href="#" class="jello-horizontal"><i class="fas fa-book"></i>Courses</a>
      <ul>
        <li><a href="selectdept">Add/Delete &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
        <li><a href="viewallcourses">View/Update &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
      </ul>
    </li>
    <li><a href="#" class="jello-horizontal"><i class="fas fa-user"></i>FacultyInfo</a>
       <ul>
        <li><a href="facultyreg">Add/Delete &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
        <li><a href="viewallfaculty">View/Update &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
      </ul>
    <li><a href="#" class="jello-horizontal"><i class="fas fa-child"></i>StudentInfo</a>
      <ul>
        <li><a href="insertstudent">Add/Delete &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
        <li><a href="viewallstudents">View/Update &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li>
        
      </ul>
     
    </li>
     
      <li><a href="registrationstatus" class="jello-horizontal">Registration INFO&nbsp&nbsp</a></li>
      
      
      <li><a href="addannouncement" class="jello-horizontal"><i class="fas fa-home"></i >Announcements</a></li>
    <li><a href="home" class="jello-horizontal"><i class="fa fa-sign-out"></i>Logout</a></li>
  
  </ul>
</nav>
<h1> </h1>
<h1> </h1>
<br>
<br>
<br>
<br>
</body>
</html>