package com.demo;

import org.jetbrains.annotations.NotNull;

import com.coxautodev.graphql.tools.SchemaParser;
import com.demo.repository.AuthorRepository;
import com.demo.repository.PostRepository;
import com.demo.repository.UserRepository;
import com.demo.resolver.AuthorResolver;
import com.demo.resolver.Mutation;
import com.demo.resolver.PostResolver;
import com.demo.resolver.Query;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository,UserRepository userRepository) {
		super(buildSchema(postRepository,authRepository,userRepository));
	}
	@NotNull
	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository,UserRepository userRepository ) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository,authRepository,userRepository),
						new Mutation(authRepository,postRepository,userRepository ),
						new PostResolver(authRepository),
						new AuthorResolver(postRepository))
				.build()
				.makeExecutableSchema();
	}

}
