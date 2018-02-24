package com.MavenProject.SmartBookBorrow.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MavenProject.SmartBookBorrow.model.Book;
import com.MavenProject.SmartBookBorrow.service.BorrowService;

@Path("/borrow")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BorrowResource {
	BorrowService borrowService = new BorrowService();

	@GET
	public List<Book> getAllBooks() {
		return borrowService.getAllBooks();
	}
	
	@GET
	@Path("/{bookId}")
	public Book getBook(@PathParam("bookId") int id) {
		return borrowService.getBook(id);
	}
}
