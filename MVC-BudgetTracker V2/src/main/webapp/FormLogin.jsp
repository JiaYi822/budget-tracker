<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
body{
background-image: url("https://wallpaperaccess.com/full/1826227.jpg");
  height: 100%;
  width: 100%;
  margin: 0;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.button {
  background-color: #229ADC;
  border: none;
  color: white;
  padding: 12px 140px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 1.0;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  border-radius: 12px;
}

.button:hover {opacity: 0.7}

input[type=text], select {
  width: 85%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
 <script type="text/javascript">
	function validateForm() {
		if (document.myForm.userName.value == null
				|| document.myForm.userName.value == "") {
			alert("Please key-in username");
			return false;
		}
		if (document.myForm.password.value == null
				|| document.myForm.password.value == "") {
			alert("Please key-in password");
			return false;
		} 
		var username = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		
		if ( userName == "Formget" && password == "formget#123"){
		alert ("Login successfully");
		}
		else {
			alert("Username is not registered!");
			return false;
		}
		
		if ( !checkUser(username)) {
			alert("Username is not registered!");
			return false;
		}
		
	}
</script>
</head>
<title>User Login</title>


<body>
<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 40px; font-weight: bold; color: white; position: absolute; left:0.5%"><span style="color: #229ADC">M</span >y<span style="color: #229ADC">B</span >udget<span style="color: #229ADC">T</span>racker</h1>
	<div class="rectangle" style="height: 600px; width: 520px; background-color: #555; position: absolute; top: 14%; right: 8.5%; opacity: 0.8; border-radius: 15px;"></div>

	 
	<div class="container" style="position: absolute; top:17%; right: 17%">
		
		
		<div class="row">
			<div class="col-md-4" style="color: white; font-size: 25px">
				<form name="myForm" action="UserAccountController?action=LOGIN" onSubmit="return validateForm()" method="post" style="position: absolute; top: 45%; left:225%;">
					<div class="form-group" style="color: white; font-size: 25px">
						<p><span class="glyphicon glyphicon-user" style="color: white; position: absolute; top:13.5%; right: 105%;"></span></p>   
						<p><span class="glyphicon glyphicon-lock" style="color: white;  position: absolute; top:36.5%; right: 105%;"></span></p>   
						Username: <br/><input type="text" name="userName" placeholder="Enter Username" value="${user.userName}" style="color: grey; font-size: 15px;"/>
					</div>
					<div class="form-group" style="color: white; font-size: 25px">
						Password: <br/><input type="password" name="password" placeholder="Enter Password" value="${user.password}" style="color: grey; width:85%; border-radius:4px; padding: 10px 25px; font-size: 15px; border: 1px solid #ccc;"/>
					</div><br/>


					
					<input class="button "type="submit"  name="LOGIN" value="Login"/>   <!--Error instantiating servlet class -- is for name  -->
					<br/>
					<br/>	
					<br/>
						
					New Here? <br/><input class="button" type="button" onclick="window.location.href = '/MVC-BudgetTracker/FormRegistration.jsp'" value="Register" />
				
				<!-- <input class="button" type="reset" name="reset" value="Reset" />  -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>