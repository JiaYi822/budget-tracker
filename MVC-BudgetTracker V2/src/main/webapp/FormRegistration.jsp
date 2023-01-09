<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

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

input[type=text], select {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
</head>
<title>User Registration</title>
<script type="text/javascript">
	function validateForm() {
	/*	if (checkUser(document.myForm.username.value)) {
			alert("Username already exists! Try another Username");
		}*/
		if (document.myForm.first_name.value == null
				|| document.myForm.first_name.value == "") {
			alert("Please key-in first-name");
			return false;
		}
		if (document.myForm.last_name.value == null
				|| document.myForm.last_name.value == "") {
			alert("Please key-in last-name");
			return false;
		}
		if (document.myForm.username.value == null
				|| document.myForm.username.value == "") {
			alert("Please key-in username");
			return false;
		}
		if (document.myForm.password1.value == null
				|| document.myForm.password1.value == "") {
			alert("Please key-in password");
			return false;
		} else {
			if (document.myForm.password2.value == null
					|| document.myForm.password2.value == "") {
				alert("Please confirm password");
				return false;
			} else {
				if (document.myForm.password1.value != document.myForm.password2.value) {
					alert("Password does not match");
					return false;
				}
			}
		}
	}
</script>
<body>
<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 40px; font-weight: bold; color: white; position: absolute; left:0.5%"><span style="color: #229ADC">M</span >y<span style="color: #229ADC">B</span >udget<span style="color: #229ADC">T</span>racker</h1>
<div class="rectangle" style="height: 700px; width: 520px; background-color: #555; position: absolute; top: 8%; right: 8.5%; opacity: 0.8; border-radius: 15px;"></div>
	<div class="container">
		<p style="color: white; position: absolute; top: 11%; left: 68%">${NOTIFICATION}</p>
		<div class="row">
			<div class="col-md-4" style="position: absolute; top: 15%; left:65%; color: white; font-size: 25px">
				<form name="myForm" action="UserAccountController?action=ADD"
					onSubmit="return validateForm()" method="post">
					<div class="form-group">
						First Name: <br/><input type="text" class="form-control"
							name="first_name" placeholder="Enter Firstname"
							value="${user.firstName}"/>
					</div>
					<div class="form-group">
						Last Name: <br/><input type="text" class="form-control"
							name="last_name" placeholder="Enter Lastname"
							value="${user.lastName}" />
					</div>
					<div class="form-group">
						Username: <br/><input type="text" class="form-control" name="username"
							placeholder="Enter Username" value="${user.userName}" />
					</div>

					<div class="form-group">
						Password: <br/><input type="password" class="form-control" name="password1"
							placeholder="Enter Password" value="${user.password}" style="width: 50%"/>
					</div>
					
					<div class="form-group">
						Confirm Password: <br/><input type="password" class="form-control"
							name="password2" placeholder="Enter Password"
							value="${user.password}" style="width: 50%"/>
					</div>
					


					<input type="reset" class="btn btn-success" name="reset"
						value="Reset" /> 
						
					<input type="submit" class="btn btn-success"
						name="submit" value="Submit" /> 
						
					<input type="button"
						class="btn btn-success"
						onclick="window.location.href = '/MVC-BudgetTracker/FormLogin.jsp'"
						value="Back" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>