package com.accenture.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.accenture.config.ServiceContextTest;
import com.accenture.model.Book;

public class BookServiceTest extends ServiceContextTest {

	@Test
	public void findAll() {
		List<Book> books = bookService.findAll();
		Assert.assertTrue(!books.isEmpty());
	}
	
	@Test
	public void findByTitle() {
		String expectedTitle = "Java";
		List<Book> books = bookService.findByTitle(expectedTitle);
		books.forEach(book -> {
			String titleActual = book.getTitle();
			System.out.println(titleActual);
			Assert.assertTrue(titleActual.contains(expectedTitle));
		});

	}
	
	@Test
	public void findByIsbn() {
		String expectedIsbn = "isbn-dummy-001";
		Book book = bookService.findByIsbn("isbn-dummy-001");
		Assert.assertEquals(expectedIsbn, book.getIsbn());
	}
	
	@Test
	public void addBook() {
		Book newBook = new Book();
		newBook.setTitle("Book to be added !");
		newBook.setIsbn("isbn-dummy-001");
		
		Date date = new Date();
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		newBook.setDate_of_publication(formattedDate);
		
		Book storedBook = bookService.addBook(newBook);
		
		Assert.assertNotNull(storedBook);
	}
	
	@Test
	public void deleteBook() {
		Book newBook = new Book();
		newBook.setTitle("Book to be removed");
		newBook.setIsbn("isbn-dummy-002");
		
		Date date = new Date();
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		newBook.setDate_of_publication(formattedDate);
		
		Book storedBook = bookService.addBook(newBook);
		
		bookService.deleteBook(storedBook);
		
		Assert.assertNull(bookService.findByIsbn("isbn-dummy-002"));
	}
}
