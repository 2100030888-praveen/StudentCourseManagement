
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
.announcements-table {
  margin-top: 50px;
  
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
#profile{
          position: absolute;
          height:auto;
          right:0px;  
          height: 50px;      
          width:84px;
          border-radius: 20px;
        }
        .heartbeat:hover {
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
  <h1 style="color: aliceblue;"><i class="fa fa-graduation-cap"></i> SimpliEdu University</h1><br><br>
  <a href="studenthome"><i class="fa fa-home"></i>Home</a> 
    <a href="studentaddcourses"><i class="fa fa-plus"></i>Add Courses</a> 
    <a href="studentunregistercourse"><i class="fa fa-minus-circle"></i>Unregister Courses</a> 
     <a href="studentviewcourses"><i class="fa fa-eye"></i>View Registered Courses</a> 
     <a href="studenttodolist"><i class="fa fa-th-list"></i>To-Do List</a> 
     <a href="login">	
      <i class="fas fa-sign-in-alt"></i>LogOut</a>
</div>
<div>
  <button id="profile" class="heartbeat"><a href="studentprofile"><i class="fa fa-user" style="font-size: 25px;"></i></a></button>
  <input type="hidden" name="session_id" value="${session_id}">
  ${session_id}
  ${session_name}
</div>
<!-- <h2>Animated Sidenav Example</h2>
<p>Click on the element below to open the side navigation menu.</p> -->
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<div class="contianer">
    <div class="calendar">
      <div class="calendar-header">
        <span class="month-picker" id="month-picker"> May </span>
        <div class="year-picker" id="year-picker">
          <span class="year-change" id="pre-year">
            <pre><</pre>
          </span>
          <span id="year">2020 </span>
          <span class="year-change" id="next-year">
            <pre>></pre>
          </span>
        </div>
      </div>

      <div class="calendar-body">
        <div class="calendar-week-days">
          <div>Sun</div>
          <div>Mon</div>
          <div>Tue</div>
          <div>Wed</div>
          <div>Thu</div>
          <div>Fri</div>
          <div>Sat</div>
        </div>
        <div class="calendar-days">
        </div>
      </div>
      <div class="calendar-footer">
      </div>
      <div class="date-time-formate">
        <div class="day-text-formate">TODAY</div>
        <div class="date-time-value">
          <div class="time-formate">02:51:20</div>
          <div class="date-formate">23 - july - 2022</div>
        </div>
      </div>
      <div class="month-list"></div>
      <div class="to-do-list">
        <h2>To-Do List</h2>
        <ul class="tasks-list">
          <!-- Tasks will be added dynamically using JavaScript -->
        </ul>
      </div>
    </div>
    <div class="announcements-table">
        <h2>Announcements</h2>
        <table>
          <thead>
            <tr>
              <th>Date</th>
              <th>Title</th>
              <th>Content</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>2022-08-23</td>
              <td>New Course Added</td>
              <td>Introduction to Computer Science</td>
            </tr>
            <tr>
              <td>2022-08-23</td>
              <td>New Course Added</td>
              <td>Introduction to Computer Science</td>
            </tr>
            <tr>
              <td>2022-08-23</td>
              <td>New Course Added</td>
              <td>Introduction to Computer Science</td>
            </tr>
            <tr>
              <td>2022-08-23</td>
              <td>New Course Added</td>
              <td>Introduction to Computer Science</td>
            </tr>
            <!-- Add more rows as needed -->
          </tbody>
        </table>
      </div>
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
            <tr>
              <td>Complete Assignment 1</td>
              <td>2023-08-25</td>
              <td>  <label><input type="radio" name="task1" value="not-started">Not Started</label><br>
                <label><input type="radio" name="task1" value="in-progress">In Progress</label><br>
                <label><input type="radio" name="task1" value="completed">Completed</label>
              </td>
            </tr>
            <!-- Add more rows for other tasks -->
          </tbody>
        </table>
      </div>
    </div>

  <div>
    <p>
        
    </p>
  </div>


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
