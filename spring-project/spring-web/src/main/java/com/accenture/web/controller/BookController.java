package com.accenture.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.model.Book;
import com.accenture.service.BookService;

@Controller
public class BookController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	@RequestMapping(value = {"/"})
	public String getHome(ModelMap model) {
		model.addAttribute("book", new Book());
		return "index";
	}
	
	@GetMapping
	@RequestMapping(value = {"/library/books"})
	public String findAllBooks(ModelMap model) {
		LOGGER.info("Searching for all books in the library");
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "findAllBooks";
	}
	
	@GetMapping
	@RequestMapping(value = {"/library/book/isbn/{isbn}"})
	public String findBookByIsbn(@PathVariable("isbn") String isbn, ModelMap model) {
		LOGGER.info("Searching for book with isbn " + isbn);
		Book book = bookService.findByIsbn(isbn);
		model.addAttribute("book", book);
		return "findBookByIsbn";
	}
	
	@GetMapping
	@RequestMapping(value = {"/library/book/title/{title}"})
	public String findBookByTitle(@PathVariable("title") String title, ModelMap model) {
		LOGGER.info("Searching for book with title " + title);
		List<Book> books = bookService.findByTitle(title);
		model.addAttribute("books", books);
		return "findBookByTitle";
	}
	
	@GetMapping
	@RequestMapping(value = {"/library/book"})
	public String getAddBookView(ModelMap model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@PostMapping
	@RequestMapping(value = {"/library/book/addBook"})
	public String addBookToLibrary(@ModelAttribute("book") Book book, ModelMap model) {
		LOGGER.info("Adding book to library [isbn = "+book.getIsbn()+", title = "+ book.getTitle() + "]" );

		boolean bookAdded = bookService.addBook(book) == null ? true : false;
		model.addAttribute("bookAdded", bookAdded);
		return "index";
	}

}
