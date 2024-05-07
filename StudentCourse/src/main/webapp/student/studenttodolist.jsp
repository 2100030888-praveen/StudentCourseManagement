<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}


table {
  width: 100%;
  border-collapse: collapse;
  background-color: white;
  border-radius: 5px;
  overflow: hidden;
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.1);
}

table th, table td {
  padding: 10px;
  text-align: left;
}

table th {
  background-color: #f5f5f5;
}

table tbody tr:nth-child(even) {
  background-color: #f5f5f5;
}

table tbody tr:hover {
  background-color: #f0f0f0;
}
.heartbeat:hover  {
	-webkit-animation: heartbeat 1.5s ease-in-out infinite both;
	        animation: heartbeat 1.5s ease-in-out infinite both;
}
@-webkit-keyframes heartbeat {
  from {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-transform-origin: center center;
            transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
            transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
            transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
            transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
}
@keyframes heartbeat {
  from {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-transform-origin: center center;
            transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
            transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
            transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
            transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
}
</style>
<link rel="stylesheet" href="css/CStyle.css">
    <script src="css/CScripts.js" defer></script>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <h1 style="color: aliceblue;"><i class="fa fa-graduation-cap"></i> SimpliEdu University</h1>
 <a href="studenthome"><i class="fa fa-home"></i>Home</a> 
    <a href="studentaddcourses"><i class="fa fa-plus"></i>Add Courses</a> 
    <a href="studentunregistercourse"><i class="fa fa-minus-circle"></i>Unregister Courses</a> 
     <a href="studentviewcourses"><i class="fa fa-eye"></i>View Registered Courses</a> 
     <a href="studenttodolist"><i class="fa fa-th-list"></i>To-Do List</a> 
     <a href="login">	
      <i class="fas fa-sign-in-alt"></i>LogOut</a>
</div>

<!-- <h2>Animated Sidenav Example</h2>
<p>Click on the element below to open the side navigation menu.</p> -->
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<form method="post" action="addstudenttodolist1">
<div class="contianer">

  
      <div class="todo-list">
        <h2>To-Do List</h2>
        <table>
          <thead>
            <tr>
              <th>Task</th>
              <th>Due Date</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
        <!-- <tr>
              <td>Complete Assignment 1</td>
              <td>2023-08-25</td>
              <td>  <label><input type="radio" name="task1" value="not-started">Not Started</label><br>
                <label><input type="radio" name="task1" value="in-progress">In Progress</label><br>
                <label><input type="radio" name="task1" value="completed">Completed</label>
              </td>
            </tr> -->    
            <c:forEach items="${todolist}" var="student">
            <tr>
            	<td>${student.todotask}</td>
            	<td>${student.duedate}</td>
            	
            	<td>
            		<c:if test="${student.todostatus eq true}">
    				Done
					</c:if>
					
					<c:if test="${student.todostatus eq false}">
    				Not Done
					</c:if>
				</td>
            </tr>
            </c:forEach>
           
            
          </tbody>
        </table>
        <br>
        <br>
        <center>
        <button style="padding: 10px; border-radius: 15px;" class="heartbeat">add</button></center>
      </div>
    </div>
</form>



<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
   
</body>
</html> 
