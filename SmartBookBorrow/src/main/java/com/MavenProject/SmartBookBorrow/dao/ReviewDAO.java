package com.MavenProject.SmartBookBorrow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.MavenProject.SmartBookBorrow.config.Config;
import com.MavenProject.SmartBookBorrow.model.Review;

public class ReviewDAO {
	public static ReviewDAO ReviewDAO;
	private Statement statement;
	private Connection connection;

	private ReviewDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ReviewDAO getInstance() {
		if (ReviewDAO == null)
			ReviewDAO = new ReviewDAO();
		return ReviewDAO;
	}

	// get all Review for a all book
		public List<Review> getAllReview() {
			Review review;
			try {
				String query = String.format("select * from reviews order by user_rating desc");
				ResultSet rs = statement.executeQuery(query);
				List<Review> list = new ArrayList<>();
				while (rs.next()) {
					review = new Review();
					review.setBookId(rs.getInt("book_id"));
					review.setUserRating(rs.getDouble("user_rating"));
					list.add(review);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

	// get all Review for a specific book
	public List<Review> getAllReviewByBookId(int id) {
		Review review;
		try {
			String query = String.format("select * from reviews where book_id = %d order by user_rating desc", id);
			ResultSet rs = statement.executeQuery(query);
			List<Review> list = new ArrayList<>();
			while (rs.next()) {
				review = new Review();
				review.setUserId(rs.getInt("user_id"));
				review.setBookId(rs.getInt("book_id"));
				review.setUserRating(rs.getDouble("user_rating"));
				list.add(review);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// adds a new book
	public int addReview(Review review) {
		int id = 0;
		try {
			String query = String.format("insert into reviews (user_id, book_id, user_rating) values ('%d', '%d', '%f')", review.getUserId(), review.getBookId(), review.getUserRating()); 
			System.out.println(query);
			int res = statement.executeUpdate(query);
			if (res > 0) {
				ResultSet rs = statement.executeQuery("select max(review_id) from reviews");
				if (rs.next()) {
					System.out.println(rs.getInt(1));
					id = rs.getInt(1);
				}
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
