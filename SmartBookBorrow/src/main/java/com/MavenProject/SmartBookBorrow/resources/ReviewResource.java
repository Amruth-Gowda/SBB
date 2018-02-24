package com.MavenProject.SmartBookBorrow.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MavenProject.SmartBookBorrow.model.Review;
import com.MavenProject.SmartBookBorrow.service.ReviewService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {
	ReviewService reviewService = new ReviewService();
	
	@GET
	public List<Review> getReviews(@PathParam("bookId") int id){
		return reviewService.getReviewsForBook(id);
	}
	
	@POST
	public Review addReview(Review review) {
		return reviewService.addReview(review);
	}
	@GET
	@Path("/reviews")
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
}
