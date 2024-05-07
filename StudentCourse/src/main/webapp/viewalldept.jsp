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

<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">

<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }
  h1 {
    text-align: center;
  }
  #container {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  th {
    background-color: #f2f2f2;
  }
  .circle-button {
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 80px;
    height: 80px;
    background-color: #3498db;
    color: white;
    border: none;
    border-radius: 80%;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  .moon-icon {
    font-size: 39px; /* Adjust the size as needed */
  }
  #downloadButton {
    display: block;
    margin: 20px auto;
    padding: 10px 20px;
    font-size: 16px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  #downloadButton:hover {
    background-color: #0056b3;
  }
  #pageLengthInput {
    margin-bottom: 10px;
    padding: 5px;
    width: 50px;
    text-align: center;
  }


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
body {
    font-family: Arial, sans-serif;
  }
  .table-container {
    display: inline-flex;
    justify-content: center;
    align-items: center;
    height: 25vh; /* Adjust as needed */
  }

  table {
    width: 50%;
    border-collapse: collapse;
    margin-bottom: 20px;
  }

  th, td {
    border: 2px solid #ddd;
    padding: 8px;
    text-align: center;
  }

  th {
    background-color: #f2f2f2;
  }
  #confirm-button {
    display: block;
    margin: 0 auto;
    padding: 12px;  
    border: 4px solid #ddd;
    border-radius: 10px;
  }
  .heartbeat {
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

<link rel = stylesheet href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel = stylesheet href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
<!---data table end cdn-->
<link rel="stylesheet" href="css/CStyle.css">
    <script src="css/CScripts.js" defer></script>
</head>
<body>


<br>
<br>


  <div>
    <p>
        
    </p>
  </div>
  <%@ include file="adminnavbar.jsp" %>
  

  
  <h1>All student</h1>
  



<div id="container"  style="box-shadow: 40px 40px 40px 40px rgba(16, 16, 16, 0.2);">

  <table id="downloadTable">
    <thead>
       <tr>
            <th>Department ID</th>
            <th>Department Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>

      <c:forEach items="${departmentsList}" var="department">
            <tr>
                <td>${department.department_id}</td>
                <td>${department.department_name}</td>
                 <td>
                   <!-- <a href="editDepartment?id=${department.department_id}">Edit</a>
                    |
                    <a href="deleteDepartment?id=${department.department_id}">Delete</a>  --> 
                <a href="javascript:void(0);" onclick="confirmEdit(${department.department_id});">Edit</a>
					|
					<a href="javascript:void(0);" onclick="confirmDelete(${department.department_id});">Delete</a>
				
                </td>
            </tr>
        </c:forEach>
      <!-- Add more rows here -->
    </tbody>
  </table>

  <!-- <button class="circle-button" id="themeButton"><i class="fas fa-moon moon-icon"></i></button> -->
  <label for="pageLengthInput">Page Length: </label>
  <input type="number" id="pageLengthInput" value="10" min="1" max="100">
</div>


 
  
  
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>

<script>
  $(document).ready(function() {
    $('#downloadTable').DataTable( {
      dom: 'Bfrtip',
      buttons: [
        'copyHtml5',
        'excelHtml5',
        'csvHtml5',
        'pdfHtml5'
      ],
      pageLength: parseInt($('#pageLengthInput').val()),  // Initial page length based on input value
    });
    
    $('#pageLengthInput').on('change', function() {
      const newPageLength = parseInt($(this).val());
      $('#downloadTable').DataTable().page.len(newPageLength).draw();
    });

  
  });
</script>

   <script>
function confirmEdit(department_id) {
    var confirmation = confirm("Are you sure you want to edit this department?");
    
    if (confirmation) {
        window.location.href = "editDepartment?id=" + department_id ;
    }
}


function confirmDelete(department_id) {
    var confirmation = confirm("Are you sure you want to delete this department?");
    
    if (confirmation) {
        window.location.href = "deleteDepartment?id=" + department_id;
    }
}
</script>
</body>
</html> 
