package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.demo.repository.AuthorRepository;
import com.demo.repository.BookRepository;
import com.demo.repository.OrderRepository;
import com.demo.repository.UserRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@SpringBootApplication
public class SpringGraphqlAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlAuthApplication.class, args);
	}
	
	@Bean
	@Autowired
	public ServletRegistrationBean graphQLServlet(OrderRepository orderRepository, AuthorRepository authRepository, UserRepository userRepository,BookRepository bookRepository ) {
		return new ServletRegistrationBean(new GraphQLEntryPoint(orderRepository, authRepository,userRepository,bookRepository),"/graphql");
	}

}
