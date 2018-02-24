package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.model.User;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UserDAO {
	
	public static UserDAO UserDAO;
	private Statement statement;
	private Connection connection;

	private UserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static UserDAO getInstance() {
		if (UserDAO == null)
			UserDAO = new UserDAO();
		return UserDAO;
	}
	
	//checks login credentials of the user
	public int userLogin(String email, String password) {
		String query = String.format("select * from user_details where user_email = '%s' and user_password = '%s'",email, password);
		System.out.println(query);
		try {
			ResultSet res = statement.executeQuery(query);
			System.out.println(res);
			if(res.next())
				return 1;
			else {
				return 0;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//adds a new User
	public int addUser(User user) {
		int id = 0;
		String query = String.format("insert into user_details (user_name, user_gender, user_dob, user_address, user_email, user_password, user_mobile_number)"
				+ "values('%s', '%s', '%s', '%s', '%s', '%s', '%s')", user.getUserName(), user.getUserGender(), user.getUserDOB(), user.getUserAddress(),user.getUserEmail(), user.getUserPassword(), user.getUserMobileNumber());
		System.out.println(query);
			try {
				int res = statement.executeUpdate(query);
				if(res>0)
				{
					ResultSet rs = statement.executeQuery("select max(user_id) from user_details");
					if(rs.next())
						id = rs.getInt("userId");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return id;
	}
	
	//getting user Details
	public User getUser(int id) {
		User user = null;
		String query = String.format("select * from user_details where user_id = '%s'",id);
		
		try {
			ResultSet res = statement.executeQuery(query);
			if(res.next()) {
				user = new User();
				user.setUserId(res.getInt("user_id"));
				user.setUserName(res.getString("user_name"));
				user.setUserGender(res.getString("user_gender"));
				user.setUserAddress(res.getString("user_address"));
				user.setUserDOB(res.getString("user_dob"));
				user.setUserEmail(res.getString("user_email"));
				user.setUserPassword(res.getString("user_password"));
				user.setUserMobileNumber(res.getString("user_mobile_number"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
