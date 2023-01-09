package ssk3408.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssk3408.project.DAO.UserDAO;
import ssk3408.project.model.User;
import ssk3408.project.TransactionController;


import ssk3408.project.DAO.TransactionDAO;
import ssk3408.project.model.Transaction;
import ssk3408.project.model.User;
/**
 * Servlet implementation class UserAccountController
 */
public class UserAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao = null;
	RequestDispatcher rd = null; // an object that receives requests from the client and sends them to any resource (JSP / Servlet) 
	User holder = new User();
	
	public UserAccountController() {
		dao = new UserDAO();
	}
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		switch (action) {
		case "REGISTER":
			rd = request.getRequestDispatcher("/FormRegistration.jsp");
			rd.forward(request, response);
			break;
		case "LOGIN":
			rd = request.getRequestDispatcher("/FormLogin.jsp");
			rd.forward(request, response);
			break;
		}
	}
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		switch (action) {
		case "ADD":
			saveUser(request, response);
			
	/*		rd = request.getRequestDispatcher("/FormLogin.jsp");
			rd.forward(request, response);*/
			break;
		case "LOGIN":
		/*	rd = request.getRequestDispatcher("/FormTransaction.jsp");//returns the object of RequestDispatcher.
			rd.forward(request, response);  //Forwards a request from a servlet to another resource */
			verifyUser(request, response);
	//		listTransactions(request, response);
			break;
		}
	}

	private void verifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			String username = request.getParameter("userName");//bring data from jsp page
			String password = request.getParameter("password");
			
			boolean userFound = dao.checkUser(username); // check data with database by summoning DAO
			boolean passwordMatch = dao.checkPassword(username, password);
			
			if (userFound) {
				User theUser = dao.get(username); // if him get his username to link with password for checking
				holder = theUser;
				
				if (passwordMatch) {
					HttpSession session = request.getSession();
					session.setAttribute("user1", theUser.getUserName());
					request.setAttribute("user", theUser);
			///		request.setAttribute("action", "LOGIN");
					
				//	theUser.setUserName(holder.getUserName());
					rd = request.getRequestDispatcher("/MainMenu.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("NOTIFICATION", "Incorrect Username and Password!");
					rd = request.getRequestDispatcher("/FormLogin.jsp");
					rd.forward(request, response);
				}

			} else {
				request.setAttribute("NOTIFICATION", "User Not Found!");
				rd = request.getRequestDispatcher("/FormLogin.jsp");
				rd.forward(request, response);
			}
			
			
	}
	//			String storedUsername = theUser.getUserName();
	//			String storedPassword = theUser.getPassword();
			//	boolean matchingPassword = ();
		//		boolean matchingPassword = dao.checkPassword(storedUsername, storedPassword);
			//	boolean matchingPassword = (password == storedPassword);
	
			protected void saveUser(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
				User u = new User();
				u.setFirstName(request.getParameter("first_name"));
				u.setLastName(request.getParameter("last_name"));
				u.setUserName(request.getParameter("username"));
				u.setPassword(request.getParameter("password2"));
				
				if (!dao.checkUser(u.getUserName()) && dao.save(u)) {
					request.setAttribute("NOTIFICATION", "Your account is Registered Successfully!");
					
				}else {
					request.setAttribute("NOTIFICATION","Username already exists! Try another Username");
					
				}
				 
				

				request.setAttribute("user", u);
				RequestDispatcher rd = request.getRequestDispatcher("/FormRegistration.jsp");
				rd.forward(request, response);
			}
	

	
}
