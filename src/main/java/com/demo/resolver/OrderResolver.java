package com.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.model.Book;
import com.demo.model.OrderDetail;
import com.demo.model.User;
import com.demo.repository.BookRepository;
import com.demo.repository.UserRepository;

public class OrderResolver implements GraphQLResolver<OrderDetail> {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	public OrderResolver(BookRepository bookRepository, UserRepository userRepository) {
		super();
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
	}
	
	
	/*
	 * public Country getCountry(City city) { return
	 * countryRepo.findById(city.getCountry().getCountryId()).orElseThrow(null);
	 * 
	 * }
	 */
	
	public Book getBook(OrderDetail order) {
		return bookRepository.findById(order.getBook().getBookId()).orElseThrow(null);
	} 
	
	public User getUser(OrderDetail order) {
		return userRepository.findById(order.getUser().getUserId()).orElseThrow(null);
		
	}
	
	

}