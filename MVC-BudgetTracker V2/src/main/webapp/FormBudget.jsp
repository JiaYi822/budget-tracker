<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Budget Target</title>

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
<!--  <div class="rectangle" style="height: 100%; width: 100%; background-color: white; position: absolute; opacity: 0.6;"></div>-->
	<div class="rectangle" style="height: 40px; width: 420px; background-color: #555; position: absolute; top: 44.8%; left: 28%; opacity: 0.8; border-radius: 6px;"></div>
	<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 50px; font-weight: bold; color: white; position: absolute; left:1%; top:1%;"><span style="color: #229ADC">T</span >argeted<span style="color: #229ADC">B</span>udget</h1>
<p style="text-align: center; color: white; font-weight: bold; position: absolute; top: 9%; left:2%;">View the targeted budget here.</p>
	<form action="TransactionController" method="post">
<table class="table table-dark table-striped table-hover" style="width: 60%; margin: 0; position: absolute; top: 23%; left: 20%;">
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
		<td>${accommodation}</td>
		<td>${food}</td>
		<td>${outgoingtransfer}</td>
		<td>${shopping}</td>
		<td>${transportation}</td>
	<tr>
	</tbody>
</table>

<h3 style="position: absolute; top: 45.3%; left:29%; color: white; font-size:25px;"> Total amount spent for the month:</h3>
<input type="month" name="date" style="position: absolute; top: 45.5%; left:53%;">
<table class="table table-dark table-striped table-hover" style="width: 25%; margin: 0; position: absolute; top: 51%; left: 27%;">
<thead class="thead-light">
		<tr>
			<th>Expense Category</th>
			<th>Total</th>
		</tr>
		</thead>
		<tbody>
<tr><td>Total Accommodation :</td> <td>${accommodationTotal}</td></tr>
<tr><td>Total Food :</td> <td>${foodTotal}</td></tr>
<tr><td>Total Outgoing Transfer :</td> <td>${outgoingTransTotal}</td></tr>
<tr><td>Total Shopping :</td> <td>${shoppingTotal}</td></tr>
<tr><td>Total Transportation :</td> <td>${transportationTotal}</tr>

</tbody>
</table>
	
	
	<!--<table class="table table-dark table-striped table-hover" style="width: 25%; margin: 0; position: absolute; top: 51%; left: 60%;">
<thead class="thead-light">
		<tr>
			<th>Income Category</th>
			<th>Total</th>
		</tr>
		</thead>
		<tbody>
<tr><td>Total Salary :</td> <td>${salaryTotal}</td></tr>
<tr><td>Total Incoming Transfer :</td> <td>${incomingTransTotal}</td></tr>
<tr><td>Total Other Income :</td> <td>${otherIncomeTotal}</td></tr>

</tbody>
</table>-->
	
	<div class="rectangle" style="height: 40px; width: 350px; background-color: #555; position: absolute; top: 85%; left: 29%; opacity: 0.8; border-radius: 6px;"></div>
	<p style="position: absolute; top:85.5%; left:30%; color: white; font-weight: bold; font-size: 20px;">Total Expense : ${totalExpense}</p>
	<button name="action" value="GETTOTAL" style="background-color: #229ADC; padding: 5px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:44.9%; left:65%">Check Total</button>
	<button name="action" value="GETUPDATEBUDGET" style="background-color: #18C517; padding: 5px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top: 18%; left:71%">Update Budget</button>
	<button name="action" value="TOMAINMENU" style="background-color: #DE4C0D; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:5%; right:2%">Back</button>

	</form>
	</body>
</html>