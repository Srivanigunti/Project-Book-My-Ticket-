<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #363ff4;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
<body>
<form action="registration" style="border:1px solid #ccc">
  <div class="container">
  <h1>${message}</h1>
    <h1>Sign Up TO Book Your Ticket</h1>
    <p>Please fill in this form to create an account in BookMyMovie.</p>
    <hr>
	
	 <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Your Name" name="fullName" required>

    <label for="email"><b>Email</b></label><br>
    <input type="email" placeholder="Enter Email" name="emailId" required><br><br>
    
    <label for="Contact Number"><b>Contact Number</b></label>
    <input type="text" placeholder="Enter Contact Number" name="contactNumber" required>
    
     <label for="UserAddress"><b>Address:</b></label><br><br>
     &nbsp;&nbsp;&nbsp;<label for="House Number"><b>House Number</b></label>
    <input type="text" placeholder="Enter House Number" name="address.houseNumber" required>
    
     &nbsp;&nbsp;&nbsp;<label for="Street Name"><b>Street Name</b></label>
    <input type="text" placeholder="Enter Street Name" name="address.streetName" required>
    
     &nbsp;&nbsp;&nbsp;<label for="District"><b>District</b></label>
    <input type="text" placeholder="Enter District Name" name="address.district" required>
    
     &nbsp;&nbsp;&nbsp;<label for="State"><b>District</b></label>
    <input type="text" placeholder="Enter State Name" name="address.state" required>
    
     &nbsp;&nbsp;&nbsp;<label for="Country"><b>Country</b></label>
    <input type="text" placeholder="Enter Country Name" name="address.country" required>
    
    <label for="Date Of Birth"><b>Date Of Birth</b></label>
    <input type="date" placeholder="Enter Date Of Birth" name="dateOfBirth" required><br><br>
    
     <label for="Gender"><b>Gender</b></label>
    <input type="text" placeholder="Enter Male or Female" name="gender" required>
    
     <label for="Marital status"><b>Marital status</b></label>
    <input type="text" placeholder="Enter Marital status" name="maritalStatus" required>
    

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>
    
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
      
    </div>
  </div>
</form>

</body>
</html>