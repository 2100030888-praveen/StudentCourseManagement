<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  /* background-image: url('./images/about.jpg'); */
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
  <button id="profile" class="heartbeat"><i class="fa fa-user" style="font-size: 25px;"></i><a href="studentprofile"></a></button>
</div>
<!-- <h2>Animated Sidenav Example</h2>
<p>Click on the element below to open the side navigation menu.</p> -->
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>



  <div>
    <!-- <img src="" alt="..."> -->
    <br>    <br>
		<center>
<i class="fa fa-user-circle" style="font-size: 150px;"></i>
<p>Profile</p>
<br>
<br>
<label>Id&nbsp; :</label> &nbsp; <input type="text" value="0" style="align-items: center;"><br>
<label>Name&nbsp; :</label> &nbsp; <input type="text" value="MND" style="align-items: center;"><br>
<label>Email&nbsp; :</label> &nbsp; <input type="text" value="mamidipraveen2784@gmail.com" style="align-items: center;"><br>
<label>DoB&nbsp; :</label> &nbsp; <input type="text" value="12/09/2002" style="align-items: center;"><br>
<label>Course&nbsp; :</label> &nbsp;
 <input type="text" value="[java , c , python, oracle]" style="align-items: center;"><br>
 <label>Year.sem</label> <input type="text" value="3.1" style="align-items: center;"><br>
 <label>Departement</label> <input type="text" value="CSE" style="align-items: center;"><br>

</center>
 
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
