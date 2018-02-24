package com.MavenProject.SmartBookBorrow.service;

import java.util.List;

import com.MavenProject.SmartBookBorrow.dao.BorrowDAO;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BorrowService {
	private BorrowDAO borrowDAO;

	public BorrowService()
	{
		borrowDAO = BorrowDAO.getInstance();
	}
	
	public List<Book> getAllBooks(){
		return borrowDAO.getAllBooks();
	}
	
	
	public Book getBook(int id) {
		return borrowDAO.getBook(id);
	}
}
