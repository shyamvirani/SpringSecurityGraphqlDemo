package com.demo.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.demo.model.Author;
import com.demo.model.Post;
import com.demo.model.User;
import com.demo.repository.AuthorRepository;
import com.demo.repository.PostRepository;
import com.demo.repository.UserRepository;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/rest/graphql")
public class Query implements GraphQLRootResolver {

	@Autowired
	private  PostRepository postRepository;
	@Autowired
	private  AuthorRepository authRepo;
	@Autowired
	private UserRepository userRepository;
	public Query(PostRepository postRepository, AuthorRepository authRepo,UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.authRepo = authRepo;
		this.userRepository=userRepository;
	}
	


	@GetMapping("/getProlist")
	public List<Post> allOrders() {
		return postRepository.findAll();
	}

	@GetMapping("/list")
	public List<Author> allAuthors() {
		return authRepo.findAll();
	}

	public Optional<Author> getAuthor(Long Id){
		 return authRepo.findById(Id);
		
	}

	public User loginUser(String userName){
		User dbUser=userRepository.findByUserName(userName);
//		System.out.println(dbUser.getName());
		return dbUser;
	}

	public List<User> allUsers() {
		return userRepository.findAll();
	}

}