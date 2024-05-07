<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="path-to-your-boxicons-css-file.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'></link>
    <link rel="stylesheet" href="path-to-font-awesome-css-file.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>About Us</title>
    
   <title>About Us</title>
</head>
<body>
   <%@ include file="navbar.jsp" %>
   <div style>
  <img src="images/about.jpg" width="100%"  height="1000%" class="bounce-in-fwd">
  <img src="images/a2.jpg"  width="100%"  height="100%" class="bounce-in-fwd">
</div>
 <%@ include file="footer.jsp" %>

<script>
  // Get the button element
  var button = document.getElementById("myButton");
  
  // Add a click event listener to the button
  button.addEventListener("click", function() {
      // Navigate to the specified URL when the button is clicked
      window.location.href = "home.html";
  });
</script>
<script>
  // Smooth scrolling function
  function smoothScroll(target) {
    const element = document.querySelector(target);
    if (element) {
      window.scrollTo({
        top: element.offsetTop,
        behavior: 'smooth'
      });
    }
  }

  // Add event listener to the "Services" link
  const servicesLink = document.querySelector('a[href="#contact"]');
  if (servicesLink) {
    servicesLink.addEventListener('click', function (e) {
      e.preventDefault(); // Prevent default anchor behavior
      smoothScroll(this.getAttribute('href'));
    });
  }
</script>
</body>
</html>