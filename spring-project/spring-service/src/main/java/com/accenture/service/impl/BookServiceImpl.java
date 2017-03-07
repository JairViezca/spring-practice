package com.accenture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.dao.repository.BookRepository;
import com.accenture.model.Book;
import com.accenture.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
	
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleLike(title);
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
