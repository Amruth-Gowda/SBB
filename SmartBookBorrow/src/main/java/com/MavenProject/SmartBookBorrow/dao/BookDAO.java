package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BookDAO {
	public static BookDAO BookDAO;
	private Statement statement;
	private Connection connection;

	private BookDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static BookDAO getInstance() {
		if (BookDAO == null)
			BookDAO = new BookDAO();
		return BookDAO;
	}

	// get all the Books
	public List<Book> getAllBooks() {
		Book book;
		try {
			String query = String.format("select * from book_details");
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
				book.setCanBorrow(rs.getInt("can_borrow"));
				list.add(book);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// adds a new book
	public int addBook(Book book) {
		int id = 0;
		try {
			String query = String.format(
					"insert into book_details (book_name, book_author, book_desc, book_image_path, can_buy, can_borrow) values ('%s', '%s', '%s', '%s', '%d', '%d')",
					book.getBookName(), book.getBookAuthor(), book.getBookDesc(), book.getBookImagePath(), book.getCanBuy(), book.getCanBorrow());
			int res = statement.executeUpdate(query);
			if (res > 0) {
				ResultSet rs = statement.executeQuery("select max(book_id) from book_details");
				if (rs.next())
					id = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	// get a book from the database
	public Book getBook(int id) {
		Book book = new Book();
		try {
			String query = String.format("select * from book_details where book_id = %d", id);
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

	// updates book details
	public Book updateBook(Book book) {
		try {
			String query = String.format("update book_details set to book_name = '%s' book_author = '%s' book_desc='%s' where book_id = '%d'",
					book.getBookName(), book.getBookAuthor(), book.getBookDesc(), book.getBookId());
			statement.executeUpdate(query);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	//deletes book 
	public Book deleteBook(Book book) {
		try {
			String query = String.format("delete from book_details where book_id = '%d'",book.getBookId());
			statement.executeUpdate(query);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
}
