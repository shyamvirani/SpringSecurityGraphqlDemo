package com.demo.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.demo.model.User;

@Component
public class JwtGenerator {
		public String generate(User jwtUser) {
			
			 Claims claims = Jwts.claims()
		                .setSubject(jwtUser.getUserName());
		        claims.put("password", String.valueOf(jwtUser.getPassword()));
		        claims.put("role", jwtUser.getRole());

	
		        return Jwts.builder()
		                .setClaims(claims)
		                .signWith(SignatureAlgorithm.HS512, "Graphql")
		                .compact();
		}
	
}
