<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0"> 
    <title>Organizer Dashboard</title> 
 
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"> 
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet"> 
    <link type="text/css" rel="stylesheet" href="css/adminhome.css">
</head>

<body>
 <%@ include file="adminnavbar.jsp" %>

<div class="grid-container"> 
 
     
 
      
      <!-- Main --> 
      <main class="main-container"> 
        <div class="main-title"> 
          <p class="font-weight-bold" ><h2>Total Users</h2></p> 
        </div> 
 
        <div class="main-cards"> 
 
          <div class="card"> 
            <div class="card-inner"> 
            <i class="fas fa-landmark"></i>
            <p class="text-primary">Total Departments</p> 
                
              <span class="material-icons-outlined text-blue"></span> 
            </div> 
            <span class="text-primary font-weight-bold"></span> 
          </div> 
 
 
          <div class="card"> 
          
            <div class="card-inner"> 
             <i class="fas fa-user"></i>
              <p class="text-primary">Total Faculty</p> 
             
              <span class="material-icons-outlined text-green"></span> 
            </div> 
            <span class="text-primary font-weight-bold"></span> 
          </div> 
 
          <div class="card"> 
          
            <div class="card-inner"> 
             <i class="fas fa-child"></i>
              <p class="text-primary">Total Students</p> 
              
              <span class="material-icons-outlined text-red"></span> 
            </div> 
            <span class="text-primary font-weight-bold"></span> 
          </div> 
           
          <div class="card"> 
            <div class="card-inner"> 
            <i class="fas fa-book"></i>
              <p class="text-primary">Total Courses</p> 
                
              <span class="material-icons-outlined text-pink"></span> 
            </div> 
            <span class="text-primary font-weight-bold"></span> 
          </div> 
 
        </div> 
 
         
      </main> 
      <!-- End Main --> 
 
    </div> 
 
    <!-- Scripts --> 
    <!-- ApexCharts --> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.3/apexcharts.min.js"></script> 
    <!-- Custom JS --> 
    <script src="js/scripts.js"></script>
</body>
</html>