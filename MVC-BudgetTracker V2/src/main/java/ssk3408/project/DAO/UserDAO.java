package ssk3408.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ssk3408.project.model.User;

public class UserDAO {
	Connection connection = null; // to establish a connection with the database
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	public boolean checkPassword(String username, String password) {
		Boolean found = false;
		try {
			String sql = "SELECT * FROM users2 where username='" + username + "'" + "AND user_password = '" + password + "'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();//to create SQL basic statements in Java it provides methods to execute queries with the database. 
			resultSet = statement.executeQuery(sql); // execute query --- maintains a cursor pointing to a row of a table.
			if (resultSet.next()) { //to move the cursor to the one row next from the current position.
				found = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	public boolean save(User u) {
		boolean flag = false;

		try {
			String sql = "INSERT INTO users2(username, user_password, first_name, last_name )VALUES" + "('"
					+ u.getUserName() + "','" +  u.getPassword() + "', '" + u.getFirstName()
					+ "', '" + u.getLastName() + "')";

			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean checkUser(String username) {
		Boolean found = false;
		try {
			String sql = "SELECT * FROM users2 where username='" + username + "'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				found = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public User get(String username) {
		User user = new User();
		try {
			
			String sql = "SELECT * FROM users2 where username='" + username + "'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user.setFirstName(resultSet.getString("first_name")); //getting data from database & setting the instance of model
				user.setLastName(resultSet.getString("last_name"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean delete(String firstname) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM users2 where firstname='" + firstname + "'";
			System.out.println(sql);
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(User user) {
		boolean flag = false;
		try {
			String sql = "UPDATE users2 SET firstname ='" + user.getFirstName() + "', lastname = '" + user.getLastName()
					+ "', username = '" + user.getUserName() + "', password = '"
					+ user.getPassword() + "' where firstname='" + user.getFirstName() + "'";

			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<User> getUser() {
		List<User> list = null;
		User user = new User();

		try {
			list = new ArrayList<User>();
			String sql = "SELECT * FROM users2 order by firstname asc";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				user = new User();
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
		}

		return list;
	}
	
	public void addBudget(String username) {
		try {
		String sql = "INSERT INTO budget(username, accommodation, food, outgoingtransfer, shopping, transportation )VALUES" + "('"
				+ username + "', '0', '0', '0', '0', '0'" + ")";


	//	System.out.println(sql);
		connection = DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		
		}catch (Exception e) {
			
		}
	}
	

}
