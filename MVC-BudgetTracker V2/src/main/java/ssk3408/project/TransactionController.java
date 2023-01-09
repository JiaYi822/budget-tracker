package ssk3408.project;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.Renderer;

import ssk3408.project.BudgetValidation;
import ssk3408.project.DAO.TransactionDAO;
import ssk3408.project.model.Transaction;
import ssk3408.project.model.User;
import ssk3408.project.model.Budget;
import ssk3408.project.model.Report;
import ssk3408.project.DAO.UserDAO;


public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDAO transactionDAO = null;
	RequestDispatcher rD = null;
	String clickDelete = "";
	String clickUpdate = "";
//	User holder = new User();
	
  
    public TransactionController() {
    	transactionDAO = new TransactionDAO(); 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at doGet: ").append(request.getContextPath());
		String action = request.getParameter("action");
		switch (action) {

		
		case "LISTTRANSACTION":
			listTransactions(request, response);
			break;
			
		case "BUDGET":
			showBudget(request, response);
			break;
	
/*		case "REPORT" :
			showReport(request, response);*/
			
	/*	case "GETTOTAL" :
			displayTotal(request, response);*/
			
		case "UPDATEBUDGET":
			updateBudget(request, response);
			
		case "GETUPDATETRANSACTION":
			getUpdateForm(request, response);
			break;
			
		}
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at doPost: ").append(request.getContextPath());
		String action = request.getParameter("action");
		switch (action) {
		
		case "TOMAINMENU" : 
			String username = getCurrentUsername(request);
			request.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("/MainMenu.jsp");
			rd.forward(request, response);
			break;
			
		case "TOBUDGET" : 
			showBudget(request, response);
			break;
			
		case "ADD":
			addTransaction(request, response);
			break;
			
		case "DELETE":
			deleteTransactionDate(request, response);
			break;
			
		case "ADDTRANSACTION":  
			addTransaction(request, response);
			
			break;
		case "DELETETRANSACTION":
			deleteTransaction(request, response);
			break;
			
/*		case "GETUPDATETRANSACTION":
			getUpdateForm(request, response);
			break;*/
			
		case "UPDATEBUDGET":
			updateBudget(request, response);
		break;
		case "GETTOTAL" :
			displayTotal(request, response);
			break;
		case "LISTTRANSACTION":
			listTransactions(request, response);
			break;
		case "GETUPDATEBUDGET" :
			getUpdateForm(request, response);
			break;
			
		}
		
	
	}
	
	///////////////////// Total by month & type
private void displayTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.getWriter().append("Served at: displayTotal").append(request.getContextPath());
	String username = getCurrentUsername(request);
	request.setAttribute("username", username);
	
	String date = request.getParameter("date");
	request.setAttribute("date", date);
	System.out.println(date);
	TransactionDAO dao = new TransactionDAO();
	
	String totalShopping = dao.getTotalShopping(username, date);
	String totalAccommodation = dao.getTotalAccommodation(username, date);
	String totalFood = dao.getTotalFood(username, date);
	String totalOutgoingTransfer = dao.getTotalOutgoingTransfer(username, date);
	String totalTransport = dao.getTotalTransport(username, date);
	double totalExpense = Double.parseDouble(totalShopping) + Double.parseDouble(totalAccommodation) + Double.parseDouble(totalFood) + Double.parseDouble(totalOutgoingTransfer) + Double.parseDouble(totalTransport);
	String totalexpense = totalExpense + "";
	
	/*String totalSalary = dao.getTotalSalary(username, date);
	String totalIncomingTransfer = dao.getTotalIncomingTransfer(username, date);
	String totalOtherIncome = dao.getTotalOtherIncome(username, date);
	double totalIncome = Double.parseDouble(totalSalary) + Double.parseDouble(totalIncomingTransfer) + Double.parseDouble(totalOtherIncome);
	String totalincome = totalIncome + "";
	
	
	
	double netIncome = totalIncome - totalExpense;
	String netincome = netIncome + "";*/
	request.setAttribute("shoppingTotal", totalShopping);
	request.setAttribute("accommodationTotal", totalAccommodation);
	request.setAttribute("foodTotal", totalFood);
	request.setAttribute("outgoingTransTotal", totalOutgoingTransfer);
	request.setAttribute("transportationTotal", totalTransport);
	request.setAttribute("totalExpense", totalexpense);
	/*request.setAttribute("salaryTotal", totalSalary);
	request.setAttribute("incomingTransTotal", totalIncomingTransfer);
	request.setAttribute("otherIncomeTotal", totalOtherIncome);
	request.setAttribute("totalIncome", totalincome);
	request.setAttribute("netIncome", netincome);*/
	
	
	showBudget(request, response);
	
	
/*	RequestDispatcher rd = request.getRequestDispatcher("/FormTotal.jsp");
	rd.forward(request, response);*/
	}

private void getUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at getUpdateForm: ").append(request.getContextPath());
	String username = getCurrentUsername(request);
	request.setAttribute("username", username);
	TransactionDAO dao = new TransactionDAO();

	Budget obj = dao.getBudget(username); //Returns a budget object

	
	request.setAttribute("accommodation", obj.getAccommodation());
	System.out.println( "fgegt  " + obj.getAccommodation());
	request.setAttribute("food", obj.getFood());
	System.out.println( "fgegt  " + obj.getFood());
	request.setAttribute("outgoingtransfer", obj.getOutgoingTransfer());
	request.setAttribute("shopping", obj.getShopping());
	request.setAttribute("transportation", obj.getTransportation());

	RequestDispatcher rd = request.getRequestDispatcher("/UpdateBudget.jsp");
	rd.forward(request, response);
	
	
	}

private void updateBudget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at updateBudget: ").append(request.getContextPath());
		
		String username = getCurrentUsername(request);
		request.setAttribute("username", username);
		
//		BudgetValidation bv = new BudgetValidation();
//		ArrayList<String> budgets = new ArrayList<String>();
//		ArrayList<String> output = new ArrayList<String>();
//
//		budgets = getBudgetDetail(request, response);
//		output = bv.validateBudget(budgets);
		
//		List<Budget> theList = dao.getBudget(username);
/*		Budget obj = new Budget();
		obj.setAccommodation("500");
		obj.setFood("4400");*/
		Budget obj = new Budget(); //Returns a budget object

		obj.setAccommodation(request.getParameter("accommodation"));
		obj.setFood(request.getParameter("food"));
		obj.setOutgoingTransfer(request.getParameter("outgoingTransfer"));
		obj.setShopping(request.getParameter("shopping"));
		obj.setTransportation(request.getParameter("transportation"));
	
		System.out.println( "fgegt  " + obj.getAccommodation());
/*		obj.setAccommodation("56");
		obj.setFood("89");
		obj.setOutgoingTransfer("945");
		obj.setShopping("45");
		obj.setTransportation("323");
		*/
		TransactionDAO dao = new TransactionDAO();
		dao.updateBudget(username, obj);
		
		showBudget(request,response);
/*		RequestDispatcher rd = request.getRequestDispatcher("/FormBudget.jsp");
		rd.forward(request, response);*/
	
		
	}

/*	private double[] getBudget(HttpServletRequest request, HttpServletResponse response) {
		Budget u = new Budget();
		TransactionDAO dao = new TransactionDAO();
		Budget[] array = new Budget[5];
		
		for (int i = 0 ; i<array.length ; i++) {
			
		}
		
	}*/
	
	/*	private double[] getBudget(HttpServletRequest request, HttpServletResponse response) {
		Budget u = new Budget();
		TransactionDAO dao = new TransactionDAO();
		Budget[] array = new Budget[5];
		
		for (int i = 0 ; i<array.length ; i++) {
			
		}
		
	}*/
/*	private void updateBudget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Transaction dao = new Transaction();
		
		String username = getCurrentUsername(request);
		request.setAttribute("username", username);
		Budget u = new Budget();
		u.setAmount(request.getParameter("amount"));
		
		String type = getBudgetSelected(request);
	
		switch(type) {
		case "ACCOMMODATION" : dao.update(u);
		break;
		case "FOOD" : transactionDAO.saveExpense(u);
		break;
		case "OUTGOING TRANSFER" : transactionDAO.saveExpense(u);
		break;
		case "SHOPPING" : transactionDAO.saveExpense(u);
		break;
		case "TRANSPORTATION" : transactionDAO.saveExpense(u);
		break;	
		}
	}*/

public ArrayList<String> getBudgetDetail(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	ArrayList<String> BudgetDetail = new ArrayList<String>();
	String accommodation = request.getParameter("accommodation");
	String food = request.getParameter("food");
	String outgoingTransfer = request.getParameter("outgoingTransfer");
	String shopping = request.getParameter("shopping");
	String transportation = request.getParameter("transportation");

	BudgetDetail.add(accommodation);
	BudgetDetail.add(food);
	BudgetDetail.add(outgoingTransfer);
	BudgetDetail.add(shopping);
	BudgetDetail.add(transportation);

	return BudgetDetail;
}

	
	public void showBudget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at showBudget: ").append(request.getContextPath());
		
		String username = getCurrentUsername(request);
		request.setAttribute("username", username);
				
		TransactionDAO dao = new TransactionDAO();
//		List<Budget> theList = dao.getBudget(username);
/*		Budget obj = new Budget();
		obj.setAccommodation("500");
		obj.setFood("4400");*/
		Budget obj = dao.getBudget(username); //Returns a budget object

		
		request.setAttribute("accommodation", obj.getAccommodation());
		
		request.setAttribute("food", obj.getFood());

		request.setAttribute("outgoingtransfer", obj.getOutgoingTransfer());
		request.setAttribute("shopping", obj.getShopping());
		request.setAttribute("transportation", obj.getTransportation());
		
		
/*		obj.setAccommodation("56");
		obj.setFood("89");
		obj.setOutgoingTransfer("945");
		obj.setShopping("45");
		obj.setTransportation("323");
		*/
		RequestDispatcher rd = request.getRequestDispatcher("/FormBudget.jsp");
		rd.forward(request, response);
	
	}


	protected void addTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at addTransaction: ").append(request.getContextPath());
		
	//	String username = 
		Transaction u = new Transaction();
		u.setCategory(request.getParameter("transactiontype"));
		u.setAmount(request.getParameter("amount"));
		u.setDate(request.getParameter("transactiondate"));
		u.setTime(request.getParameter("transactiontime"));
//		u.setUserName("SRW2799");
		HttpSession session = request.getSession();
		u.setUserName((String) session.getAttribute("user1"));
/*		User user = new User();
		u.setUser(user);*/
		
		String type = u.getCategory();
		switch(type) {
		case "ACCOMMODATION" :
		case "FOOD" : 
		case "OUTGOING TRANSFER" : 
		case "SHOPPING" : 
		case "TRANSPORTATION" : 
		transactionDAO.saveExpense(u);
		break;	
		
		case "SALARY" : 
		case "INCOMING TRANSFER" :
		case "OTHER INCOME" : 
		transactionDAO.saveIncome(u);
		break;
		} 
	/*	
		switch(type) {
		case "A01" : transactionDAO.saveExpense(u);
		break;
		case "F01" : transactionDAO.saveExpense(u);
		break;
		case "O01" : transactionDAO.saveExpense(u);
		break;
		case "S01" : transactionDAO.saveExpense(u);
		break;
		case "T01" : transactionDAO.saveExpense(u);
		break;	
		case "O02" : transactionDAO.saveExpense(u);
		break;
		case "salary" : transactionDAO.saveIncome(u);
		break;
		case "incomingtransfer" : transactionDAO.saveIncome(u);
		break;
		case "other income" : transactionDAO.saveIncome(u);
		break;
		}
		*/
	//	transactionDAO.saveExpense(u);
		
		request.setAttribute("transaction", u);
		RequestDispatcher rd = request.getRequestDispatcher("/FormAddTransaction.jsp"); // Calling this page after execution.
		rd.forward(request, response);
		
	}
	
	public void listTransactions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at listTransactions: ").append(request.getContextPath());
		
		String user1 = request.getParameter("userName");
		response.getWriter().append("Served at listTransactions: ").append(request.getContextPath());
		UserDAO dao = new UserDAO();
		User theUser = dao.get(user1); 
		request.setAttribute("user", theUser);

		String username = getCurrentUsername(request);
	//	String username = request.getParameter("user");
		
	//	User theUser = transactionDAO.get(username); 
			
		Transaction transaction = new Transaction();
	//	transaction.setUserName(username);
		
		TransactionDAO Tdao = new TransactionDAO();
		List<Transaction> theList = Tdao.getTransaction(username);  //getTransaction method
		request.setAttribute("transaction", theList);
		RequestDispatcher rd = request.getRequestDispatcher("/FormTransaction.jsp");
		rd.forward(request, response);

	}
		
	private void deleteTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at deleteTransaction: ").append(request.getContextPath());
		String username;
	//	String username = request.getParameter("userName");
		
	//	User theUser = transactionDAO.get(username); 
			
		Transaction transaction = new Transaction();
	//	transaction.setUserName(username);
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("user1");
		System.out.print(username);
		TransactionDAO dao = new TransactionDAO();
		List<Transaction> theList = dao.getTransaction(username);  //getTransaction method
		request.setAttribute("transaction", theList);
		RequestDispatcher rd = request.getRequestDispatcher("/DeleteTransaction.jsp");
		rd.forward(request, response);

		
	}
/*	
	private void deleteSingleTransactionDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = "SRW2799";
		String deleteDate = request.getParameter("deletedate");
		
		TransactionDAO dao = new TransactionDAO();
		dao.deleteTransaction(deleteDate);
	
	
		
	}*/
	
	private void deleteTransactionDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at deleteTransactionDate: ").append(request.getContextPath());
		
		String deleteDate = request.getParameter("deletedate");
		TransactionDAO dao = new TransactionDAO();
		String username = getCurrentUsername(request);
		System.out.println("delete ni");
		if (dao.delete(deleteDate, username)) {
			request.setAttribute("NOTIFICATION", "Transactions Deleted Successfully!");
			clickDelete = "";
		}
		
		Transaction transaction = new Transaction();
		//	transaction.setUserName(username);
			
		List<Transaction> theList = dao.getTransaction(username);  //getTransaction method
		request.setAttribute("transaction", theList);

		RequestDispatcher rd = request.getRequestDispatcher("/DeleteTransaction.jsp");
		rd.forward(request, response);

	}
	
	private String getCurrentUsername (HttpServletRequest request) {
		HttpSession s = request.getSession();
		return (String) s.getAttribute("user1");
	}
	


}