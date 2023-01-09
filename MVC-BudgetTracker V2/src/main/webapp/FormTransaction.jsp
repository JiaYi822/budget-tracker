<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Transaction Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


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
  background-repeat: repeat;
  background-size: cover;
}

</style>

</head>

<body>

<div class="rectangle" style="height: 100%; width: 100%; background-color: white; position: absolute; opacity: 0.6;  margin: 0; repeat: repeat; size: cover;"></div>
<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 50px; font-weight: bold; color: white; position: absolute; left:1%; top:1%;"><span style="color: #229ADC">T</span >ransaction</h1>
<p style="text-align: center; color: white; font-size: 20px; font-weight: bold; position: absolute; top: 9%; left:2%;">View the transaction history here.</p>
	<!--  <img src="https://www.neuro-insight.com/wp-content/uploads/2019/03/My-Budget.png" alt="My Budget Logo" width="130" height="100" style="float: left;">-->

	
	<!-- <div class="rectangle" style="height: 40px; width: 140px; background-color: orange; position: absolute; opacity: 1.0; top:3%; right:1%"></div>
	<p style="text-align: right; position:absolute; top: 3.8%; right:3%; font-style: italic; font-weight: bold;">	User: <span id= "userName" >${user.userName}</span></p>-->
	<form name="transactionForm" action="TransactionController" method="post">
	<input type="button" onclick="window.location.href = '/MVC-BudgetTracker/FormAddTransaction.jsp'" value="+ Add Transaction" style="position: absolute; background-color: #18C517; padding: 5px 15px; border-radius: 5px; top: 20%; left:3.5%"/>
	<button class="btn-group button" name="action" value="DELETETRANSACTION" style="position: absolute; background-color: #DE4C0D; padding: 5px 15px; border-radius: 5px; top: 30%; left:3%">- Delete Transaction</button>
		
	<!-- 	<form name="transactionForm" action="TransactionController?action=ADDTRANSACTION" method="post" >
		<input type="submit" value="+ Add Transaction"  name = "ADDTRANSACTION">
		</form>
		<form name="transactionForm" action="TransactionController?action=DELETETRANSACTION" method="post" >
		<input type="submit" value="- Delete Transaction" name = "DELETETRANSACTION">
		</form>
					 -->	
	 	
	
		
		
<!-- 		<input type="button" onclick="window.location.href = '/MVC-BudgetTracker/DeleteTransaction.jsp'" value="- Delete Transaction" />  -->

<!--  
	<table class="center" style="width: 25%">
		<tr>
			<td>Current balance</td>
			<td>Income</td>
			<td>Expense</td>
		</tr>
		<tr>
			<td>$2850.00</td>
			<td>$1500.00</td>
			<td>$350.00</td>
		</tr>
	</table>-->

	

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
	
	<input type="button" class="btn btn-success" onclick="window.location.href = '/MVC-BudgetTracker/MainMenu.jsp'" value="Back" style="background-color: #DE4C0D; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:5%; right:2%"/>
	
</form>
	<br />
	<br />

</body>

</html>