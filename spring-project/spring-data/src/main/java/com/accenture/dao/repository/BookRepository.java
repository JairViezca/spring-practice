package com.accenture.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.model.Book;

@Repository("booksRepository")
public interface BookRepository extends JpaRepository<Book, String>{
	
	@Query("select b from Book b where b.title like %?1")
	public List<Book> findByTitleLike(String title);
	
	@Query("select b from Book b where b.isbn = ?1")
	public Book findByIsbn(String isbn);
}
