<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Budget Target</title>

<script type="text/javascript">
function validateForm() {
	if (document.setBudget.accommodation.value == "" || document.setBudget.shopping.value == "" ||
		document.setBudget.food.value == "" || document.setBudget.transportation.value == "" || document.setBudget.outgoingTransfer.value == "") {
		alert("Please key-in amount.");
		return false;
	}
	
	var num1 = document.setBudget.accommodation.value;

	if(num1.match(/^-?\d+$/)){
	 
	}else if(num1.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
	
	var num2 = document.setBudget.food.value;

	if(num2.match(/^-?\d+$/)){
	 
	}else if(num2.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
	
	var num3 = document.setBudget.shopping.value;

	if(num3.match(/^-?\d+$/)){
	 
	}else if(num3.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
	
	var num4 = document.setBudget.transportation.value;

	if(num4.match(/^-?\d+$/)){
	 
	}else if(num4.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
	
	var num5 = document.setBudget.outgoingTransfer.value;

	if(num5.match(/^-?\d+$/)){
	 
	}else if(num5.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
	
	if(document.setBudget..value;)
}

</script>

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

</style>
</head>

<body>
<div class="rectangle" style="height: 100%; width: 100%; background-color: white; position: absolute; opacity: 0.6;"></div>

<form name = "setBudget" action = "TransactionController" method = "post" onSubmit="return validateForm()">
<table class="table table-dark table-striped table-hover" style="width: 60%; margin: 0; position: absolute; top: 23%; left: 18%;">
	<thead class="thead-light">
	<tr>
		<th>Accommodation</th>
		<th>Food</th>
		<th>Outgoing Transfer</th>
		<th>Shopping</th>
		<th>Transportation</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td><input type="text" name="accommodation" value="${accommodation}" /></td>
		<td><input type="text" name="food" value="${food}" /></td>
		<td><input type="text" name="outgoingTransfer" value="${outgoingtransfer}" /></td>
		<td><input type="text" name="shopping" value="${shopping}" /></td>
		<td><input type="text" name="transportation" value="${transportation}" /></td>
	<tr>
	</tbody>
</table>
<!-- 	<input type = "submit" name = "action" value = "UPDATEBUDGET"> -->
	<button type = "submit" name = "action" value = "UPDATEBUDGET" style="background-color: #18C517; padding: 5px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top: 18%; left:74%">Update</button>
	<button type = "submit" name = "action" value = "TOBUDGET" style="background-color: #DE4C0D; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:5%; right:2%">Go Back</button>
<!--  <button type = "submit" name = "action" value = "TOBUDGET">Back</button>-->	
</form>
</body>
</html>