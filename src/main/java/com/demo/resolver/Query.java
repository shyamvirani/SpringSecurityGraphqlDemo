package com.demo.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.model.OrderDetail;
import com.demo.model.User;
import com.demo.repository.AuthorRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.OrderRepository;
import com.demo.repository.UserRepository;


@CrossOrigin(origins = "*",maxAge = 3600)
@Service
public class Query implements GraphQLRootResolver {

	@Autowired
	private  OrderRepository orderRepository;
	@Autowired
	private  AuthorRepository authRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public Query(OrderRepository orderRepository, AuthorRepository authRepository, UserRepository userRepository,
			BookRepository bookRepository) {
		super();
		this.orderRepository = orderRepository;
		this.authRepository = authRepository;
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
	}
	

	
	public List<OrderDetail> allOrders() {
		return orderRepository.findAll();
	}
	
	public List<Author> allAuthors() {
		return authRepository.findAll();
	}
	
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	
	
	public Optional<OrderDetail> getOrder(Long Id){
		 return orderRepository.findById(Id);	
	}
	public Optional<Author> getAuthor(Long authorId){
		 return authRepository.findById(authorId);	
	}
	
	public Optional<User> getUser(Long Id){
		 return userRepository.findById(Id);	
	}
	public Optional<Book> getBook(Long Id){
		 return bookRepository.findById(Id);	
	}
	

	public User loginUser(String userName){
		User dbUser=userRepository.findByUserName(userName);
//		System.out.println(dbUser.getName());
		return dbUser;
	}



}