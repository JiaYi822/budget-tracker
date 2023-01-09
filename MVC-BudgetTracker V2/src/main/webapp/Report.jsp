<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<meta charset="UTF-8">
<title>Report Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<style>

.v1 {
  border-left: 3px solid grey;
  height: 500px;
  position: absolute;
  top:0%;
  height: 100%;
  left: 13%;
  opacity: 0.3;
}

.{
	margin:0;
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

</style>

</head>

<body style="background-color: white;">

	<div class="v1"></div>
	
	<img src="https://www.neuro-insight.com/wp-content/uploads/2019/03/My-Budget.png" alt="My Budget Logo" width="130" height="100" style="position: absolute; top: 2%; left: 2%;">
	<h1 style="text-align: center;">Report</h1>
	<p style="text-align: center;">Check your income and expense for the month.</p>

	<table class="btn-group button" style="position: absolute; top: 20%; left: 1%">
		<tr>
			<td><button style="width: 100%">Transactions</button></td>
		</tr>
		<tr>
			<td><button style="width: 100%">Budget</button></td>
		</tr>
		<tr>
			<td><button style="width: 100%">Report</button></td>
		</tr>
	</table>

	<canvas id="income" style="width: 100%; max-width: 320px; position: absolute; top: 16%; left: 30%"></canvas>

	<script>
		var xValues = [ "Salary", "Outgoing Transfer", "Other" ];
		var yValues = [ 55, 49, 44 ];
		var barColors = [ "#b91d47", "#00aba9", "#2b5797" ];

		new Chart("income", {
			type : "doughnut",
			data : {
				labels : xValues,
				datasets : [ {
					backgroundColor : barColors,
					data : yValues
				} ]
			},
			options : {
				title : {
					display : true,
					text : "Income"
				}
			}
		});
	</script>

	<canvas id="expense" style="width: 100%; max-width: 320px; position: absolute; top: 15%; left: 60%"></canvas>

	<script>
		var xValues = [ "Accommodation", "Food", "Outgoing Transfer", "Shopping", "Transportation"];
		var yValues = [ a, b, c, d, e ];
		var barColors = [ "#FFD35C", "#F37252", "#EA3E70", "#4BC4D5", "#02B5A0", "#8A9747" ];

		new Chart("expense", {
			type : "doughnut",
			data : {
				labels : xValues,
				datasets : [ {
					backgroundColor : barColors,
					data : yValues
				} ]
			},
			options : {
				title : {
					display : true,
					text : "Expense"
				}
			}
		});
	</script>

<form action="/action_page.php" style="">
  <label for="transactionmonth">Birthday (month and year):</label>
  <input type="month" id="month" name="transactionmonth">
  <input type="submit">
</form>

</body>

</html>