package com.MavenProject.SmartBookBorrow.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int bookId, canBuy, canBorrow;
	private String bookName, bookAuthor, bookDesc, bookImagePath;

	public Book() {
	}

	public Book(int bookId, String bookName, String bookAuthor, String bookDesc, int canBorrow, int canBuy) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDesc = bookDesc;
		this.canBorrow = canBorrow;
		this.canBuy = canBuy;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public int getCanBuy() {
		return canBuy;
	}

	public void setCanBuy(int canBuy) {
		this.canBuy = canBuy;
	}

	public int getCanBorrow() {
		return canBorrow;
	}

	public void setCanBorrow(int canBorrow) {
		this.canBorrow = canBorrow;
	}

	public String getBookImagePath() {
		return bookImagePath;
	}

	public void setBookImagePath(String bookImagePath) {
		this.bookImagePath = bookImagePath;
	}

}
