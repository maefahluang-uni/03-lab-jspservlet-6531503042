<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
   <head>
      <title>BMI Calculator</title>
   </head>
   <body>
      <img src="https://www.cdc.gov/healthyweight/images/assessing/bmi-adult-fb-600x315.jpg?_=07167">
      <!-- Display the calculated BMI below -->
      <h2>Result is <%= request.getAttribute("bmi") %></h2>
      <!-- Display the determined built type below -->
      <h3>According to your BMI, you are considered <%= request.getAttribute("build") %></h3>
   </body>
</html>