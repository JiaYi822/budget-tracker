<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Delete Transaction</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>

.{margin:0;
  position:absolute;
  top:20%;
  left:50%;
  -ms-transform:translate(-50%,-50%);
  transform:translate(-50%,-50%);
}

.center {
	margin-left: auto;
	margin-right: auto;
}

.btn-group button {
	padding: 10px 15px;
	cursor: pointer;
	display: flex;
	justify-content: left;
	align-items: center;
}

.btn-group button:hover {
	background-color: #E1E1E1;
}

.tab1 {
	tab-size: 2;
}

.table {
	border-spacing: 10px;
}

th, td {
	border: "";
	padding: 7px;
	border-spacing: 10px;
}

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

<body style="background-color: #F7EFEF;">

	<div class="rectangle" style="height: 100%; width: 100%; background-color: white; position: absolute; opacity: 0.6;"></div>
	<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 40px; font-weight: bold; color: white; position: absolute; left:1%; top:1%;"><span style="color: #229ADC">D</span >elete <span style="color: #229ADC">T</span>ransactions</h1>
	<p style="text-align: center; color: black; font-weight: bold; position: absolute; top: 8%; left:2%;">Delete your transactions here.</p>
		
		
	<form name="deleteForm" action="TransactionController?action=DELETE" method="post">	
	
	
	<div align = "center" style="position: absolute; top: 16%; left:2%; font-weight: bold">Select a date to delete the transactions : <br/></div>
	<input type="date" id="deletedate" name="deletedate" style="position: absolute; top:20%; left:2%;">
	<input type="reset" class="btn btn-success" name="reset" value="Reset" style="background-color: #229ADC; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:8%; right:8%"/> 
	<input type="submit" class="btn btn-success" onclick="return confirm('Are you sure you want to delete all transactions on this date?');" name="submit" value="Delete" style="background-color: #18C517; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:8%; right:14%"/> 
	<input type="button" class="btn btn-success" onclick="window.location.href = '/MVC-BudgetTracker/MainMenu.jsp'" value="Back" style="background-color: #DE4C0D; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:8%; right:2%"/>
	
	<h2 style="position: absolute; top:15%; left:25%">Expense</h2>
	<table class="table table-dark table-striped table-hover" style="width: 30%; margin: 0; position: absolute; top: 20%; left: 25%;">
		<thead class="thead-light">
		<tr>
			<th>Expense Category</th>
			<th>Date</th>
			<th>Time</th>
			<th>Amount</th>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${transaction}" var="transaction">
				<c:if test="${transaction.category == 'SHOPPING' || transaction.category == 'FOOD' || transaction.category == 'TRANSPORTATION' || transaction.category == 'ACCOMMODATION' || transaction.category == 'OUTGOING TRANSFER'}">	
				
				<tr>
				<td>${transaction.category}</td>
				<td>${transaction.date}</td>
				<td>${transaction.time}</td>
				<td>${transaction.amount}</td>
			   </c:if>	
		</c:forEach>
		</tbody>
	</table>
	
	<h2 style="position: absolute; top:15%; left: 60%">Income</h2>
	<table class="table table-dark table-striped table-hover" style="width: 30%; margin: 0; position: absolute; top: 20%; left: 60%;">
		<thead class="thead-light">
		<tr>
			<th>Income Category</th>
			<th>Date</th>
			<th>Time</th>
			<th>Amount</th>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${transaction}" var="transaction">
				<c:if test="${transaction.category == 'SALARY' || transaction.category == 'INCOMING TRANSFER' || transaction.category == 'OTHER INCOME'}">	
				
				<tr>
				<td>${transaction.category}</td>
				<td>${transaction.date}</td>
				<td>${transaction.time}</td>
				<td>${transaction.amount}</td>
			   </c:if>	
		</c:forEach>
		</tbody>
	</table>
	</form>
	
	<br />
	<br />

</body>

</html>