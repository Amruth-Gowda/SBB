package com.MavenProject.SmartBookBorrow.service;

import java.util.List;

import com.MavenProject.SmartBookBorrow.dao.ReviewDAO;
import com.MavenProject.SmartBookBorrow.model.Review;

public class ReviewService {
	ReviewDAO reviewDao = ReviewDAO.getInstance();
	
	
	public List<Review> getAllReviews(){
		return reviewDao.getAllReview();
	}
	
	public List<Review> getReviewsForBook(int id){
		return reviewDao.getAllReviewByBookId(id);
	}
	
	public Review addReview(Review review) {
		int id = reviewDao.addReview(review);
		review.setReviewId(id);
		System.out.println("inside service"+id);
		return review;
	}
	
}
