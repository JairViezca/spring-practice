package com.accenture.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS", schema="mydb")
public class Book {

	@Id
	private String isbn;
	
	private String title;
	
	private String date_of_publication;

	public String getDate_of_publication() {
		return date_of_publication;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setDate_of_publication(String date_of_publication) {
		this.date_of_publication = date_of_publication;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
