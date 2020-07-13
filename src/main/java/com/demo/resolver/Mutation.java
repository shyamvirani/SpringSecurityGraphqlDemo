package com.demo.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.demo.model.Author;
import com.demo.model.Book;
import com.demo.model.OrderDetail;
import com.demo.model.User;
import com.demo.repository.AuthorRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.OrderRepository;
import com.demo.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Service
public class Mutation implements GraphQLRootResolver {
	@Autowired
	private AuthorRepository authRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;

	public Mutation(AuthorRepository authRepository, OrderRepository orderRepository, UserRepository userRepository,
			BookRepository bookRepository) {
		super();
		this.authRepository = authRepository;
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
	}
	

	public Author addAuthor(String authorName) {
		/*
		 * Author author = new Author(); author.setAuthorName(authorName);
		 * authRepository.save(author); return author;
		 */
		return authRepository.save(new Author(authorName));

	}

	public OrderDetail addOrder(Integer quantity, Integer amount, Long user, Long book) {
		OrderDetail order = new OrderDetail();
		order.setQuantity(quantity);
		order.setBook(new Book(book));
		order.setUser(new User(user));
		Optional<Book> b = bookRepository.findById(book);
		Book bookObj = b.get();
		order.setAmount(quantity * bookObj.getPrice());
		orderRepository.save(order);
		return order;

	}

	public User addUser(String userName, String email, String password, String role) {
		User newUser = new User();
		newUser.setUserName(userName);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setRole(role);
		return userRepository.save(newUser);
	}
	//addBook(bookName:String!,price:Int!,author:ID!):Book
	
	public Book addBook(String bookName,Integer price, Long author) {
		Book book=new Book();
		book.setAuthor(new Author(author));
		book.setBookName(bookName);
		book.setPrice(price);
		bookRepository.save(book);
		return book;
		
	}
	
	
	
	public OrderDetail orderProceed(Long id, String orderProceed) {
		Optional<OrderDetail> o = orderRepository.findById(id);
		OrderDetail order = o.get();
		order.setOrderProceed(orderProceed);
		return orderRepository.save(order);
	}

	/*
	 * public Author updateAuthor(Long id, String authorName, String price) { Author
	 * author = new Author(id, authorName, price); author.setPrice(price);
	 * author.setAuthorName(authorName); return authRepo.save(author); }
	 */

	public Boolean deleteAuthor(Long id) {
		authRepository.deleteById(id);
		return true;
	}
	public Boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}
	public Boolean deleteOrder(Long id) {
		orderRepository.deleteById(id);
		return true;
	}
	public Boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}

}