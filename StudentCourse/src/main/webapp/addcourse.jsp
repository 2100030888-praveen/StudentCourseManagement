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


<font color="blue">${message}</font><br><br>

<br>
<h3 align=center><u>Add Course</u></h3>

<br>

<form method="post" action="addcourse">
 
<table align=center>

<tr>
<td><label>Course Id</label></td>
<td>
<input type="text" name="id" required="required"/>
</td>
</tr>

<tr><td></td></tr>


<tr>
<td><label>Course Name</label></td>
<td>
<input type="text" name="name" required="required"/>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Course code</label></td>
<td>
<input type="text" name="code" required="required"/>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Course credits</label></td>
<td><input type="number" name="credits" STEP="0.01" required/></td>
</tr>

<tr><td></td></tr>

<input type="hidden" name="dept" value="${dept}">


<tr>
    <td><label>CC</label></td>
    <td>
        <select name="cc" required>
            <option value="">---Select---</option>
            <c:forEach items="${faculty}" var="f">
                <option value="${f.id}">${f.name}</option>
            </c:forEach>
        </select>
    </td>
</tr>
<tr><td></td></tr>



<tr>
<td><label>course year</label></td>
<td>
<select name="year" required>
<option value="">---Select---</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
</td></tr>

<tr><td></td></tr>


<tr>
<td><label>course sem</label></td>
<td>
<select name="sem" required>
<option value="">---Select---</option>
<option value="1">1</option>
<option value="2">2</option>
</select>
</td></tr>

<tr><td></td></tr>


<tr>
<td><label>Limit Number of enrollments</label></td>
<td><input type="number" name="enrollments" required/></td>
</tr>

<tr><td></td></tr>



<tr>
<td><label>Course Description</label></td>
<td><input type="text" name="description" required/></td>
</tr>

<tr><td></td></tr>



<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>

</form>


</body>
</html>