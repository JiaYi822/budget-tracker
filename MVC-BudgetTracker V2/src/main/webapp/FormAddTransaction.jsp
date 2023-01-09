<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Transaction</title>
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

</style>

<script type="text/javascript">
function validateForm() {
	if (document.addTransactionForm.amount.value == null
			|| document.addTransactionForm.amount.value == "") {
		alert("Please key-in amount.");
		return false;
	}
	
	var num = document.addTransactionForm.amount.value;

	if(num.match(/^-?\d+$/)){
	 
	}else if(num.match(/^\d+\.\d+$/)){
	
	}else{
	  alert("Amount should be in digits.")
	  return false;
	}
}



</script>



</head>

<body>
	<!--  <div class="rectangle" style="height: 100%; width: 100%; background-color: white; position: absolute; opacity: 0.6;"></div>-->
	<div class="rectangle" style="height: 400px; width: 700px; background-color: #555; position: absolute; top: 23.5%; left: 30.5%; opacity: 0.8; border-radius: 15px;"></div>
	<h1 style="font-family: Copperplate, Papyrus, fantasy; font-size: 40px; font-weight: bold; color: white; position: absolute; left:1%; top:-3%;"><span style="color: #229ADC">A</span >dd <span style="color: #229ADC">T</span>ransactions</h1>
	<p style="text-align: center; color: white; font-size: 20px; font-weight: bold; position: absolute; top: 5%; left:1.5%;">Add your transactions here.</p>
	
	<!-- onSubmit="return validateForm()" -->
	<form name="addTransactionForm" onSubmit="return validateForm()" action="TransactionController?action=ADDTRANSACTION"  method="post" style="position: absolute; top: 24%; left:29%; color: white;">
	<!--  <p style="text-align: right;">	User Name: <span id= "userName" name="userName">${user.userName}</span></p>-->
	<table style="padding: 5px 5px; font-size: 25px; border:none; border-collapse: separate; border-spacing: 50px 40px;">
	<tr style="font-weight: bold; color: white"> 
	<td>Category:</td>
	
	
	
	<td>Amount:</td> 
	
	</tr>
	
	<tr>
	
	<td>
	<select id = "transactiontype" name = "transactiontype" value = "${transaction.category}" style="padding: 15px 32px; font-size:15px;">
	<option value="0">------ SELECT TRANSACTION ------</option>
	<option value="0">------Expense------</option>
	<option value="ACCOMMODATION">ACCOMMODATION</option>
	<option value="FOOD">FOOD</option>
	<option value="OUTGOING TRANSFER">OUTGOING TRANSFER</option>
	<option value="SHOPPING">SHOPPING</option>
	<option value="TRANSPORTATION">TRANSPORTATION</option>
	<option value="0">-------Income-------</option>
	<option value="SALARY">SALARY</option>
	<option value="INCOMING TRANSFER">INCOMING TRANSFER</option>
	<option value="OTHER INCOME">OTHER INCOME</option>
	</select>
	</td>
	
	<td><input type="text" name="amount" placeholder="Enter Amount" style="padding: 15px 32px; font-size:15px;"></td>
	</tr>
	
	<tr style="font-weight: bold; color: white"> 
	<td>Date:</td> 
	
	<td>Time:</td> 
	</tr>
	<tr>
	<td><input type="date" id="transactiondate" name="transactiondate" style="padding: 15px 32px; font-size:15px;"></td>
	
	<td><input type="time" id="transactiontime" name="transactiontime" style="padding: 15px 32px; font-size:15px;"></td>
	</tr>
	
	</table>
	
	<input type="reset" name = "reset" value ="Reset" style="background-color: #229ADC; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:-40%; right:-25%">
	<input type="submit" name = "ADDTRANSACTION" value ="Save" style="background-color: #18C517; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:-40%; right:-40%">
    <input type="button" class="btn btn-success" onclick="window.location.href = '/MVC-BudgetTracker/MainMenu.jsp'" value="Back" style="background-color: #DE4C0D; padding: 10px 20px; cursor: pointer; display: flex; justify-content: left; align-items: center; border-radius: 5px; position: absolute; top:-40%; right:-55%"/>
	
	
	</form>
	
	
</body>
</html>