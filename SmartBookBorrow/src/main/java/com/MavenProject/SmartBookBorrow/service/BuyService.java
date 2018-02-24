package com.MavenProject.SmartBookBorrow.service;

import java.util.List;

import com.MavenProject.SmartBookBorrow.dao.BuyDAO;
import com.MavenProject.SmartBookBorrow.model.Book;

public class BuyService {
	private BuyDAO buyDAO;

	public BuyService()
	{
		buyDAO = BuyDAO.getInstance();
	}
	
	public List<Book> getAllBooks(){
		return buyDAO.getAllBooks();
	}
	
	
	public Book getBook(int id) {
		return buyDAO.getBook(id);
	}
}
