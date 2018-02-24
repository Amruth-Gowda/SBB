package com.MavenProject.SmartBookBorrow.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MavenProject.SmartBookBorrow.model.Book;
import com.MavenProject.SmartBookBorrow.service.BookService;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
	
	BookService bookService = new BookService();

	@POST
	public Book addBook(Book book) {
		return bookService.addBook(book);
	}
	
	@GET
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GET
	@Path("/{bookId}")
	public Book getBook(@PathParam("bookId") int id) {
		return bookService.getBook(id);
	}
	
	@Path("/{bookId}/reviews")
	public ReviewResource getReviews() {
		return new ReviewResource();
	}
	
	@PUT
	public Book updateBook(Book book) {
		return bookService.updateBook(book);
	}
	
	@DELETE
	public Book deleteBook(Book book) {
		return bookService.deleteBook(book);
	}
	
	@Path("/buy")
	public BuyResource getAllBooksFromBuy() {
		return new BuyResource();
	}
	
	@Path("/borrow")
	public BorrowResource getAllBooksFromBorrow() {
		return new BorrowResource();
	}
}
