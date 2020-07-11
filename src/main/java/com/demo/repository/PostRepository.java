package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByAuthorId(Long authorId);
}
