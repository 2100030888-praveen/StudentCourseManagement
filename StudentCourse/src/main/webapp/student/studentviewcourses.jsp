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
          overflow-y: auto;
      }

      .sidenav {
          height: 100%;
          width: 250px;
          position: fixed;
          z-index: 1;
          top: 0;
          left: 0;
          background-color: #111;
          overflow-x: auto;
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

      body {
          font-family: Arial, sans-serif;
      }

      .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            gap: 30px;
            max-width: 960px;
            margin: 0 auto;
        }

        .card {
            box-shadow: 0 4px 100px 0 rgba(0, 0, 0, 0.2);
            flex: 0 1 calc(33.33% - 20px);
            text-align: center;
            padding: 20px;
            border: 2px solid #ddd;
            display: flex;
            flex-direction: column;
        }

        .card img {
            max-width: 100%;
        }

        .title {
            color: grey;
            font-size: 18px;
        }

        .card-content {
            flex-grow: 1;
        }

        .button-container {
            margin-top: auto; /* Pushes the button to the bottom */
        }

        button {
            border: none;
            outline: 0;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
            margin-top: auto; /* Pushes the button to the bottom of the card */
        }
</style>
<link rel = stylesheet href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel = stylesheet href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
<!---data table end cdn-->
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


  
  <center>
<h1>Your Courses</h1>

</center>
<input type="hidden" name="session_id" value="${session_id}">

<c:if test="${empty msg}">
<div class="card-container">
<c:forEach items="${courselist}" var="c">
<div class="card">
  <img src="images/algebra.jpeg" alt="John" style="width:100%">
<input type="hidden" name="course_id" value="${c.course_id}">
    <p>Course ID: ${c.course_id}</p>
    <h1>Course Name: ${c.course_name}</h1>
    <p>Course Code: ${c.course_code}</p>
    <p>Course Credits: ${c.course_credits}</p>
    <p>Department ID: ${c.course_departement_id}</p>
    <p>CC ID: ${c.course_cc_id}</p>
    <p>Course Year: ${c.course_year}</p>
    <p>Course Semester: ${c.course_sem}</p>
    <p>Limit Number of Enrollments: ${c.limit_number_enrollments}</p>
    <p>Course Description: ${c.course_description}</p>
    
    <a href="course.txt" download="${c.course_name}-material.txt">Download Material</a>

    </div>
</c:forEach>
	</div>
</c:if>
<c:if test="${not empty msg}">
<center>${msg}</center>
</c:if>

  
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
