package com.MavenProject.SmartBookBorrow.service;

import java.util.List;

import com.MavenProject.SmartBookBorrow.dao.BookDAO;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BookService {
	private BookDAO bookDAO;

	public BookService()
	{
		bookDAO = BookDAO.getInstance();
	}
	
	public List<Book> getAllBooks(){
		return bookDAO.getAllBooks();
	}
	
	public Book addBook(Book book) {
		int id = bookDAO.addBook(book);
		book.setBookId(id);
		return book;
	}
	
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}
	
	public Book updateBook(Book book) {
		return bookDAO.updateBook(book);
	}
	
	public Book deleteBook(Book book) {
		return bookDAO.deleteBook(book);
	}
}
