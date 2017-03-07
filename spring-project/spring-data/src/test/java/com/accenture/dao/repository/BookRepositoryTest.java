package com.accenture.dao.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.dao.config.PersistenceContextTest;
import com.accenture.model.Book;

public class BookRepositoryTest extends PersistenceContextTest {

	@Autowired
	BookRepository booksRepository;

	@Test
	public void count() {
		long numberBooks = booksRepository.count();
		Assert.assertTrue(numberBooks > 0);
	}

	@Test
	public void findAllBooks() {
		List<Book> books = booksRepository.findAll();
		for(Book book : books) {
			System.out.println(book.getTitle());
		}
		Assert.assertFalse(books.isEmpty());
	}

	@Test
	public void findByTitle() {
		String expectedTitle = "Java";
		List<Book> books = booksRepository.findByTitleLike(expectedTitle);
		String actualTitle = books.get(0).getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

}
