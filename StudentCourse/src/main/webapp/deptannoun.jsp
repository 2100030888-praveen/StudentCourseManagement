<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<html>
<head>



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

<br>




<h3 align=center><u>Add Announcement</u></h3>

<br>

<form method="post" action="addannouncement1">
 
<table align=center>









<tr>
    <td><label>Department</label></td>
    <td>
        <select name="dept">
            <option value="0">---Select---</option>
            <c:forEach items="${departments}" var="department">
                <option value="${department.department_id}">${department.department_name}</option>
            </c:forEach>
        </select>
    </td>
</tr>
<tr><td></td></tr>












<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>

</form>


</body>
</html>