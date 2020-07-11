package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private  String authorName;
	private String price;

	


	public Author() {
		super();
	}



	public Author(Long id, String authorName, String price) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.price=price;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String name) {
		this.authorName = name;
	}

}
