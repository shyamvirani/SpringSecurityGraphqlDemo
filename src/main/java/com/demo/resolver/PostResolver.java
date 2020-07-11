package com.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.model.Post;
import com.demo.repository.AuthorRepository;

public class PostResolver implements GraphQLResolver<Post> {
	@Autowired
	private AuthorRepository authRepository;

	public PostResolver(AuthorRepository authRepository) {
		super();
		this.authRepository = authRepository;
	}

}