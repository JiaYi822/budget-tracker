<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Main Menu</title>
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

.button {
  border: none;
  color: white;
  padding: 12px 140px;
  text-align: center;
  font-size: 30px;
  margin: 4px 2px;
  opacity: 1.0;
  transition-duration: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  border-radius: 12px;
}

.button:hover {
	background-color: white;
	color: black;
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

<body>
<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 50px; font-weight: bold; color: white; position: absolute; left:1%; top:1%"><span style="color: #229ADC">M</span >ain<span style="color: #229ADC">M</span >enu</h1>
	<div class="rectangle" style="height: 300px; width: 500px; background-color: #555; position: absolute; top: 31.5%; left: 33.5%; opacity: 0.8; border-radius: 15px;"></div>
	<!--<img src="https://www.neuro-insight.com/wp-content/uploads/2019/03/My-Budget.png" alt="My Budget Logo" width="130" height="100" style="float: left;">-->
	<form name="mainMenuForm" action="TransactionController" method="get" style="position: absolute; top:35%; left:35%;">
	
		
	<!-- 	<form name="transactionForm" action="TransactionController?action=ADDTRANSACTION" method="post" >
		<input type="submit" value="+ Add Transaction"  name = "ADDTRANSACTION">
		</form>
		<form name="transactionForm" action="TransactionController?action=DELETETRANSACTION" method="post" >
		<input type="submit" value="- Delete Transaction" name = "DELETETRANSACTION">
		</form>
					 
	 	
		<button name="action" value="ADDTRANSACTION">+ Add Transaction</button>
		<button name="action" value="DELETETRANSACTION">- Delete Transaction</button>  -->	
<!--		<input type="button" onclick="window.location.href = '/MVC-BudgetTracker/FormAddTransaction.jsp'" value="+ Add Transaction" />
		<input type="button" onclick="window.location.href = '/MVC-BudgetTracker/FormDeleteTransaction.jsp'" value="- Delete Transaction" />
-->
	<!--<table class="center" style="width: 25%">
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

	<table>
	
		<tr>
			<td><button name="action" class="button button1" value="LISTTRANSACTION" style="padding: 30px 140px; top: 10%; background-color: #229ADC;">Transaction</button></td>
		</tr>
		<tr>
			<td><button name="action" class="button button2" value="BUDGET" style="padding: 30px 165px; top: 10%; background-color: #18C517;">Budget</button></td>
		</tr>
	</table>

</form>

	<br />
	<br />

</body>

</html>