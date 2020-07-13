package com.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {
	@Autowired
	private AuthorRepository authorRepository;

	
	
	public BookResolver(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	
	public Author getAuthor(Book book) {
		return authorRepository.findById(book.getAuthor().getAuthorId()).orElseThrow(null);
	}
	
}
