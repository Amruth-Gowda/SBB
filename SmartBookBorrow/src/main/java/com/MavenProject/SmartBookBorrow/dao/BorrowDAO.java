package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BorrowDAO {
	public static BorrowDAO BorrowDAO;
	private Statement statement;
	private Connection connection;

	private BorrowDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static BorrowDAO getInstance() {
		if (BorrowDAO == null)
			BorrowDAO = new BorrowDAO();
		return BorrowDAO;
	}

	// get all the Books list for selling
	public List<Book> getAllBooks() {
		Book book;
		try {

			String query = String.format("select * from book_details where can_borrow = 1");
			ResultSet rs = statement.executeQuery(query);
			List<Book> list = new ArrayList<>();
			while (rs.next()) {
				book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookAuthor(rs.getString("book_author"));
				book.setBookDesc(rs.getString("book_desc"));
				book.setBookImagePath(rs.getString("book_image_path"));
				book.setCanBorrow(rs.getInt("can_borrow"));
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
			String query = String.format("select * from book_details where book_id = %d and can_borrow=1", id);
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
