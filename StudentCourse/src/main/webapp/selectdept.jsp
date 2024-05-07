<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Department</title>
<link type="text/css" rel="stylesheet" href="css/selectdept.css">
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<div id="contact-form">
  <div>
    
    <h2>Select Your Department</h2> 
  </div>
  <br>
  <br>
  <br>
       <form method="post" action="add1">
      <div>
          <label for="Departments">
             <select name="dept" required>
            <option value="">---Select---</option>
            <c:forEach items="${departments}" var="department">
                <option value="${department.department_id}">${department.department_name}</option>
            </c:forEach>
        </select>
          </label> 
      </div>
    <br>
    <br>
    <br>
    
      
      <div>              
          <button name="submit" type="submit"  value="Add" id="submit" >SEND</button> 
      </div>
       </form>

  </div>
</body>
</html>