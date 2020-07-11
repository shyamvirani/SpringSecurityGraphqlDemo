package com.demo.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.demo.model.Author;
import com.demo.model.Post;
import com.demo.model.User;
import com.demo.repository.AuthorRepository;
import com.demo.repository.PostRepository;
import com.demo.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Service
public class Mutation implements GraphQLRootResolver {
	@Autowired
	private AuthorRepository authRepo;
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserRepository userRepository;

	public Mutation(AuthorRepository authRepo, PostRepository postRepo, UserRepository userRepository) {
		super();
		this.authRepo = authRepo;
		this.postRepo = postRepo;
		this.userRepository = userRepository;
	}

	public Author addAuthor(Long id, String authorName, String price) {
		return authRepo.save(new Author(id, authorName, price));
	}

	public Post orderProceed(Long id, String orderProceed) {
		Optional<Post> p = postRepo.findById(id);
		Post post = p.get();
		post.setOrderProceed(orderProceed);
		return postRepo.save(post);
	}

	public Post addOrder(Long orderId, String quantity, Long authorId) {
		Optional<Author> a = authRepo.findById(authorId);
		Author auth = a.get();
		int Price = Integer.parseInt(auth.getPrice());
		if (auth != null) {

			Post post = new Post(null, quantity);
			int total = Price * Integer.parseInt(quantity);
			post.setPrice("" + total);
			post.setAuthorId(authorId);
			post.setId(orderId);
			return postRepo.save(post);
		} else
			return null;
	}

	public Author updateAuthor(Long id, String authorName, String price) {
		Author author = new Author(id, authorName, price);
		author.setPrice(price);
		author.setAuthorName(authorName);
		return authRepo.save(author);
	}

	public Boolean  deleteAuthor(Long  id) {
		authRepo.deleteById(id);
		return true;
	}

	public User createUser(String name, String password, String email) {
		User newUser = new User();
		newUser.setUserName(name);
		newUser.setPassword(password);
		newUser.setEmail(email);
		return userRepository.save(newUser);
	}
}