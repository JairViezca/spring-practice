package com.accenture.service;

import java.util.List;

import com.accenture.model.Book;

public interface BookService {

	List<Book> findAll();

	Book findByIsbn(String isbn);
	
	List<Book> findByTitle(String title);
	
	Book addBook(Book book);
	
	void deleteBook(Book book);
}
