package com.comviva.bookshelf;

public class BookIssue{
	Books book;
	boolean issued;
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public boolean getIssued() {
		return issued;
	}
	public void setIssued(boolean issued) {
		this.issued = issued;
	}
}