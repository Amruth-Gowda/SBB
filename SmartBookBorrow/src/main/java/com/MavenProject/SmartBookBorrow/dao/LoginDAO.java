package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.MavenProject.SmartBookBorrow.config.Config;

public class LoginDAO {

	public static LoginDAO LoginDAO;
	private Statement statement;
	private Connection connection;

	private LoginDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static LoginDAO getInstance() {
		if (LoginDAO == null)
			LoginDAO = new LoginDAO();
		return LoginDAO;
	}

	public int adminLogin(String email, String password) {
		String query = String.format("select * from admin where admin_email = '%s' and admin_password = '%s'",email, password);
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
}
