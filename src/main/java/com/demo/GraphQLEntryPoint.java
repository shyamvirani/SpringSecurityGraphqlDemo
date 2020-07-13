package com.demo;

import org.jetbrains.annotations.NotNull;

import com.coxautodev.graphql.tools.SchemaParser;
import com.demo.repository.AuthorRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.OrderRepository;
import com.demo.repository.UserRepository;
import com.demo.resolver.BookResolver;
import com.demo.resolver.Mutation;
import com.demo.resolver.OrderResolver;
import com.demo.resolver.Query;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(OrderRepository orderRepository, AuthorRepository authRepository,UserRepository userRepository,BookRepository bookRepository) {
		super(buildSchema(orderRepository,authRepository,userRepository,bookRepository));
	}
	@NotNull
	private static GraphQLSchema buildSchema(OrderRepository orderRepository, AuthorRepository authRepository,UserRepository userRepository,BookRepository bookRepository ) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(orderRepository, authRepository, userRepository, bookRepository),
						new Mutation(authRepository, orderRepository, userRepository, bookRepository),
						new OrderResolver(bookRepository,userRepository),
						new BookResolver(authRepository))
				.build()
				.makeExecutableSchema();
	}

}
