<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
    <!-- Include your CSS and JavaScript links here if needed -->
</head>
<body>
    <h1>Edit Course</h1>

    <form action="updateCourse" method="post">
    <lable>Course Id</lable>
        <input type="text" name="course_id" value="${course.course_id}" readonly="readonly"/>
<br>
        <label for="course_name">Course Name:</label>
        <input type="text" id="course_name" name="course_name" value="${course.course_name}" />
<br>
        <label for="course_code">Course Code:</label>
        <input type="text" id="course_code" name="course_code" value="${course.course_code}" />
<br>
        <label for="course_credits">Course Credits:</label>
        <input type="text" id="course_credits" name="course_credits" value="${course.course_credits}" />
<br>
        <input type="hidden" name="course_departement_id" value="${course.course_departement_id}" />
<label for="course_departement_name">Department Name:</label>
<input type="text" id="course_departement_name" name="course_departement_name" value="${departmentnamebyid}" readonly="readonly" />
<br>
    <!--    <label for="course_cc_id">CC ID:</label>
        <input type="text" id="course_cc_id" name="course_cc_id" value="${course.course_cc_id}" />
		<br>-->
		<label for="course_cc_id">CC :</label>
		<select name="course_cc_id" required>
            <option value="${course.course_cc_id}">${ccnameofthatcourse}</option>
            <c:forEach items="${faculty}" var="f">
                <option value="${f.id}">${f.name}</option>
            </c:forEach>
        </select>
        <label>ExistingCC=${ccnameofthatcourse}</label>
		<br>
        <label for="course_year">Year:</label>
        <input type="text" id="course_year" name="course_year" value="${course.course_year}" />
<br>
        <label for="course_sem">Semester:</label>
        <input type="text" id="course_sem" name="course_sem" value="${course.course_sem}" />
<br>
        <label for="limit_number_enrollments">Limit Number Enrollments:</label>
        <input type="text" id="limit_number_enrollments" name="limit_number_enrollments" value="${course.limit_number_enrollments}" />
<br>
        <label for="course_description">Course Description:</label>
        <textarea id="course_description" name="course_description">${course.course_description}</textarea>
<br>
        <input type="submit" value="Update Course" onclick="return confirmUpdate();" />
    </form>

    <a href="viewallcourses">Back to Courses</a>
</body>
<script>
function confirmUpdate() {
    var confirmation = confirm("Are you sure you want to update this student?");
    return confirmation;
}
</script>
</html>
