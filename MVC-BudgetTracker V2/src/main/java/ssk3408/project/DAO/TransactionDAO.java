package ssk3408.project.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ssk3408.project.model.Transaction;
import ssk3408.project.model.User;
import ssk3408.project.model.Budget;
import ssk3408.project.model.Report;

public class TransactionDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	ResultSet resultSet1 = null;
	ResultSet resultSet2 = null;
	PreparedStatement preparedStatement = null;

	public void updateBudget(String username, Budget obj) {
        System.out.println("Update Budget");
        
		try {
			String sql = "UPDATE budget SET "		
					+ "accommodation = '" + obj.getAccommodation() +"',"
					+ "food ='"+obj.getFood()+"',"
					+ "outgoingtransfer ='" + obj.getOutgoingTransfer() + "',"
					+ "shopping ='" + obj.getShopping() + "',"
					+ "transportation ='" + obj.getTransportation() + "'"
					+ "where username = '" + username + "'";

			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
        

		
//		try {
//			
//			String sql = "Update budget set accommodation = ?, food = ?, outgoingtransfer = ?, shopping = ?, transportation = ? where username = ?";
//			connection = DBConnectionUtil.openConnection();
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, obj.getAccommodation());
//			preparedStatement.setString(2, obj.getFood());
//			preparedStatement.setString(3, obj.getOutgoingTransfer());
//			preparedStatement.setString(4, obj.getShopping());
//			preparedStatement.setString(5, obj.getTransportation());
//			preparedStatement.setString(6, username);
//			
//			preparedStatement.executeUpdate();
////            if (!connection.getAutoCommit()) {
////            	connection.commit();
////          	}             
//			//connection.commit();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
		/*
		 * try { /* INSERT INTO budget(username, accommodation, food, outgoingtransfer,
		 * shopping, transportation )VALUES" + "('" + username +
		 * "', '0', '0', '0', '0', '0'" + ")";
		 */

//		String sql = ""
		// String sql = "INSERT INTO expense(username, transaction_date,
		// transaction_time, amount, expense_type)VALUES" + "('"+ u.getUserName() +
		// "','" + u.getDate() + "', '" + u.getTime() + "', '" + u.getAmount() + "', '"+
		// u.getCategory() + "')";

		/*
		 * System.out.println(); connection = DBConnectionUtil.openConnection();
		 * preparedStatement = connection.prepareStatement(sql);
		 * preparedStatement.executeUpdate(); } catch (SQLException ex) {
		 * ex.printStackTrace(); }
		 */
	}

	public void saveExpense(Transaction u) {

		try {
			String sql = "INSERT INTO expense(username, transaction_date, transaction_time, amount, expense_type)VALUES"
					+ "('" + u.getUserName() + "','" + u.getDate() + "', '" + u.getTime() + "', '" + u.getAmount()
					+ "', '" + u.getCategory() + "')";

			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void saveIncome(Transaction u) {
		try {
			String sql = "INSERT INTO income(username, transaction_date, transaction_time, amount, income_type)VALUES"
					+ "('" + u.getUserName() + "','" + u.getDate() + "', '" + u.getTime() + "', '" + u.getAmount()
					+ "', '" + u.getCategory() + "')";

			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public User get(String username) {
		User user = new User();
		try {

			String sql = "SELECT * FROM users2 where username='" + username + "'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user.setFirstName(resultSet.getString("first_name")); // getting data from database & setting the
																		// instance of model
				user.setLastName(resultSet.getString("last_name"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Transaction> getTransaction(String username) {
		List<Transaction> list = null;
		Transaction transaction = new Transaction();

		try {
			list = new ArrayList<Transaction>();
			String sql = "SELECT * FROM expense where username='" + username
					+ "' order by transaction_date desc, transaction_time desc";
			// System.out.println(sql);
			/*
			 * String sql =
			 * "select b.category_name, a.transaction_date, a.transaction_time, a.amount, b.category_name "
			 * + "from expense a join budget b on (a.category_name = b.category_name)" +
			 * " where a.username = '" + username +
			 * "' order by a.transaction_date desc, a.transaction_time desc";
			 */

			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			System.out.println("35wee");
			resultSet1 = statement.executeQuery(sql);
			System.out.println("3345ee");

			while (resultSet1.next()) {
				transaction = new Transaction();
				transaction.setCategory(resultSet1.getString("expense_type"));
				transaction.setDate(resultSet1.getString("transaction_date"));
				transaction.setAmount(resultSet1.getString("amount"));
				transaction.setTime(resultSet1.getString("transaction_time"));
				list.add(transaction);
			}
			System.out.println("ee");
			String sql2 = "SELECT * FROM income where username='" + username
					+ "' order by transaction_date desc, transaction_time desc";
			System.out.println("32875wee");

			// String sql2 = "SELECT * FROM income where username='" + username + "'";
			// System.out.println(sql2);

			/*
			 * connection = DBConnectionUtil.openConnection(); statement =
			 * connection.createStatement(); resultSet = statement.executeQuery(sql2);
			 */

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet2 = statement.executeQuery(sql2);
			/*
			 * connection = DBConnectionUtil.openConnection();
			 * 
			 * preparedStatement = connection.prepareStatement(sql2);
			 * preparedStatement.executeQuery(sql2); resultSet2 =
			 * statement.executeQuery(sql2);
			 */
			while (resultSet2.next()) {
				transaction = new Transaction();
				transaction.setCategory(resultSet2.getString("income_type"));
				transaction.setDate(resultSet2.getString("transaction_date"));
				transaction.setAmount(resultSet2.getString("amount"));
				transaction.setTime(resultSet2.getString("transaction_time"));
				list.add(transaction);
				System.out.println(sql2);
			}

		} catch (Exception e) {
		}

		return list;
	}

	public boolean delete(String deleteDate, String username) {
		boolean flag = false;
		try {
			String sql1 = "DELETE FROM expense where transaction_date='" + deleteDate + "' AND username='" + username + "'";
			System.out.println(sql1);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();

			String sql2 = "DELETE FROM income where transaction_date='" + deleteDate + "'";
			System.out.println(sql2);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Budget getBudget(String username) {
		// List<Budget> list = null;
		Budget budget = new Budget();

		try {
			// list = new ArrayList<Budget>();
			String sql = "SELECT * FROM budget where username = '" + username + "'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println("4545");

			while (resultSet.next()) {
				budget = new Budget();
				// budget.setCategory_id(resultSet.getString("category_id"));
				budget.setAccommodation(resultSet.getString("accommodation"));
				System.out.println("4dsddf");
				budget.setFood(resultSet.getString("food"));
				budget.setOutgoingTransfer(resultSet.getString("outgoingtransfer"));
				budget.setShopping(resultSet.getString("shopping"));
				budget.setTransportation(resultSet.getString("transportation"));
				System.out.println("4dfgdf");

				// list.add(budget);
			}
			System.out.println("ddfg");
		} catch (Exception e) {
		}

		return budget;
	}
	/*
	 * public Transaction getReport(String username) { Report r = new Report(); try
	 * { String sql1 =
	 * "SELECT SUM(AMOUNT)  FROM INCOME WHERE TRANSACTION_DATE LIKE '___01%' and username = '"
	 * + username; connection = DBConnectionUtil.openConnection(); statement =
	 * connection.createStatement(); resultSet1 = statement.executeQuery(sql1);
	 * 
	 * while (resultSet.next()) { r.setIncome(resultSet1.getString("amount")); }
	 * 
	 * String sql2 =
	 * "SELECT SUM(AMOUNT) FROM EXPENSE WHERE TRANSACTION_DATE LIKE '___01%' and username = '"
	 * + username; connection = DBConnectionUtil.openConnection(); statement =
	 * connection.createStatement(); resultSet2 = statement.executeQuery(sql2);
	 * 
	 * while (resultSet2.next()) { r.setCategory(resultSet2.getString("amount")); }
	 * } catch (Exception e) {
	 * 
	 * }
	 */

	public String getTotalShopping(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from expense where username = '" + username
					+ "' and transaction_date like '" + date + "%' and expense_type = 'SHOPPING'";
			System.out.println(a);
			
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			System.out.println("Hello sum amount");
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		
			System.out.println("ddfg");
		} catch (Exception e) {
		}

		return total;

	}
	
	public String getTotalAccommodation(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from expense where username = '" + username
					+ "' and transaction_date like '" + date + "%' and expense_type = 'ACCOMMODATION'";
			System.out.println(a);
			
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			System.out.println("Hello sum amount");
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		
			System.out.println("ddfg");
		} catch (Exception e) {
		}

		return total;

	}
	
	public String getTotalFood(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from expense where username = '" + username
					+ "' and transaction_date like '" + date + "%' and expense_type = 'FOOD'";
			System.out.println(a);
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			System.out.println("Hello sum amount");
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		
			System.out.println("ddfg");
		} catch (Exception e) {
		}
		return total;
	}
	
	public String getTotalOutgoingTransfer(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from expense where username = '" + username
					+ "' and transaction_date like '" + date + "%' and expense_type = 'OUTGOING TRANSFER'";
			System.out.println(a);
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			System.out.println("Hello sum amount");
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		
			System.out.println("ddfg");
		} catch (Exception e) {
		}
		return total;
	}
	
	public String getTotalTransport(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from expense where username = '" + username
					+ "' and transaction_date like '" + date + "%' and expense_type = 'TRANSPORTATION'";
			System.out.println(a);
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			System.out.println("Hello sum amount");
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		
			System.out.println("ddfg");
		} catch (Exception e) {
		}
		return total;
	}
	
	/*public String getTotalSalary(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from income where username = '" + username
					+ "' and transaction_date like '" + date + "%' and income_type = 'SALARY'";
			System.out.println(a);
			
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		} catch (Exception e) {
		}

		return total;

	}
	
	public String getTotalOtherIncome(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from income where username = '" + username
					+ "' and transaction_date like '" + date + "%' and income_type = 'OTHER INCOME'";
			System.out.println(a);
			
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		} catch (Exception e) {
		}

		return total;

	}
	public String getTotalIncomingTransfer(String username, String date) {
		String total = null;

		try {
			
			String a = "SELECT sum(AMOUNT) from income where username = '" + username
					+ "' and transaction_date like '" + date + "%' and income_type = 'INCOMING TRANSFER'";
			System.out.println(a);
			
			
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(a);
			if (resultSet.next()) {
				total = resultSet.getString(1);
				System.out.println(total);
			}
		} catch (Exception e) {
		}

		return total;

	}*/

}