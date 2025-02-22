<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Student Registration Form</title>
     <link type="text/css" rel="stylesheet" href="css/registration.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
      body{
      overflow-y: auto;
      }
      </style>
   </head>
   <body>
   
   <div><%@ include file="adminnavbar.jsp" %></div>

   <br>
 <br> 
  <br>
  <br>
  <br>
      <div class="container">
     
         <header>Student Signup Form</header>
         <div class="progress-bar">
            <div class="step">
               <p>
                  Name
               </p>
               <div class="bullet">
                  <span>1</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Contact
               </p>
               <div class="bullet">
                  <span>2</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Birth
               </p>
               <div class="bullet">
                  <span>3</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
            <div class="step">
               <p>
                  Submit
               </p>
               <div class="bullet">
                  <span>4</span>
               </div>
               <div class="check fas fa-check"></div>
            </div>
         </div>
         <div class="form-outer">
            <form action="#">
               <div class="page slide-page">
                  <div class="title">
                     Basic Info:
                  </div>
                   <div class="field">
                     <div class="label">
                        Id
                     </div>
                     <input type="number" name="id" required="required">
                  </div>
                  <div class="field">
                     <div class="label">
                        First Name
                     </div>
                     <input type="text" name="fname" required="required">
                  </div>
                  <div class="field">
                     <div class="label">
                        Last Name
                     </div>
                     <input type="text" name="lname" required="required"> 
                  </div>
                  <div class="field">
                     <button class="firstNext next">Next</button>
                  </div>
               </div>
               <div class="page">
                  <div class="title">
                     Contact Info:
                  </div>
                  <div class="field">
                     <div class="label">
                        Email Address
                     </div>
                     <input type="text" name="email" required="required">
                  </div>
                  <div class="field">
                     <div class="label">
                        Phone Number
                     </div>
                     <input type="Number" name="contact" pattern="[789][0-9]{9}" required>
                  </div>
                   <div class="field">
                     <div class="label">
                        Password
                     </div>
                     
                     <input type="text" name="pwd" value="${pwd}" required="required">
                  </div>
                  <div class="field btns">
                     <button class="prev-1 prev">Previous</button>
                     <button class="next-1 next">Next</button>
                  </div>
               </div>
               <div class="page">
                  <div class="title">
                     Date of Birth:
                  </div>
                  <div class="field">
                     <div class="label">
                        Date
                     </div>
                     <input type="date"  name="dob" required="required">
                  </div>
                  <div class="field">
                     <div class="label">
                        Gender
                     </div>
                     <select name="gender">
                     <option value="">Select Your Gender</option>
                        <option value="MALE">Male</option>
                        <option value="FEMALE">Female</option>
                     </select>
                  </div>
                  <br>
                 <br>
                
                  <div class="field btns">
                     <button class="prev-2 prev">Previous</button>
                     <button class="next-2 next">Next</button>
                  </div>
                
               </div>
               <div class="page">
                  <div class="title">
                     Academic Details:
                  </div>
                  <div class="field">
                     <div class="label">
                        Department
                     </div>
                     <select name="dept" required="required">
                        <option>Select Your Department</option>
                        <c:forEach items="${departments}" var="department">
                           <option value="${department.department_id}">${department.department_name}</option>
                        </c:forEach>
                     </select>
                  </div>
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
             
                
                  <div class="field btns">
                 
                     <button class="prev-3 prev">Previous</button>
                     <button class="submit" value="Register">Register</button>
                  </div>
                   
               </div>
            </form>
         </div>
      </div>
      <script>
      <!-- Created By CodingNepal -->
   const slidePage = document.querySelector(".slide-page");
      const nextBtnFirst = document.querySelector(".firstNext");
      const prevBtnSec = document.querySelector(".prev-1");
      const nextBtnSec = document.querySelector(".next-1");
      const prevBtnThird = document.querySelector(".prev-2");
      const nextBtnThird = document.querySelector(".next-2");
      const prevBtnFourth = document.querySelector(".prev-3");
      const submitBtn = document.querySelector(".submit");
      const progressText = document.querySelectorAll(".step p");
      const progressCheck = document.querySelectorAll(".step .check");
      const bullet = document.querySelectorAll(".step .bullet");
      let current = 1;

      nextBtnFirst.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "-25%";
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
      });
      nextBtnSec.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "-50%";
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
      });
      nextBtnThird.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "-75%";
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
      });
      submitBtn.addEventListener("click", function(){
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
        setTimeout(function(){
          
          location.reload();
        },800);
      });

      prevBtnSec.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "0%";
        bullet[current - 2].classList.remove("active");
        progressCheck[current - 2].classList.remove("active");
        progressText[current - 2].classList.remove("active");
        current -= 1;
      });
      prevBtnThird.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "-25%";
        bullet[current - 2].classList.remove("active");
        progressCheck[current - 2].classList.remove("active");
        progressText[current - 2].classList.remove("active");
        current -= 1;
      });
      prevBtnFourth.addEventListener("click", function(event){
        event.preventDefault();
        slidePage.style.marginLeft = "-50%";
        bullet[current - 2].classList.remove("active");
        progressCheck[current - 2].classList.remove("active");
        progressText[current - 2].classList.remove("active");
        current -= 1;
      });
      
      
      </script>

   </body>
</html>