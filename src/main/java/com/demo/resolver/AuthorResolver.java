package com.demo.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.model.Author;
import com.demo.model.Post;
import com.demo.repository.PostRepository;

public class AuthorResolver implements GraphQLResolver<Author> {
	@Autowired
	private  PostRepository postRepository;

	public AuthorResolver(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	public List<Post> posts(Author auth) {
		return postRepository.findByAuthorId(auth.getId());
	}

}