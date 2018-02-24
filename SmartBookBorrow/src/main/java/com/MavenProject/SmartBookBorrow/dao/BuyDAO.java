package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BuyDAO {
	public static BuyDAO BuyDAO;
	private Statement statement;
	private Connection connection;

	private BuyDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static BuyDAO getInstance() {
		if (BuyDAO == null)
			BuyDAO = new BuyDAO();
		return BuyDAO;
	}

	// get all the Books list for selling
	public List<Book> getAllBooks() {
		Book book;
		try {

			String query = String.format("select * from book_details where can_buy = 1");
			ResultSet rs = statement.executeQuery(query);
			List<Book> list = new ArrayList<>();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookAuthor(rs.getString("book_author"));
				book.setBookDesc(rs.getString("book_desc"));
				book.setBookImagePath(rs.getString("book_image_path"));
				book.setCanBuy(rs.getInt("can_buy"));
				list.add(book);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// get a book from the database
	public Book getBook(int id) {
		Book book = new Book();
		try {
			String query = String.format("select * from book_details where book_id = %d and can_buy =1", id);
			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookAuthor(rs.getString("book_author"));
				book.setBookDesc(rs.getString("book_desc"));
				book.setBookImagePath(rs.getString("book_image_path"));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}
