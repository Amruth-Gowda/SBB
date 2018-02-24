package com.MavenProject.SmartBookBorrow.model;

public class Review {
	private int reviewId, userId, bookId;
	private double userRating;

	public Review() {
	}
	
	public Review(int reviewId, int userId, int bookId, double userRating) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.bookId = bookId;
		this.userRating = userRating;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}
}
