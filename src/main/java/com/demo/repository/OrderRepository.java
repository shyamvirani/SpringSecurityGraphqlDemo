package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.OrderDetail;
@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
	
	//List<Order> findByAuthorId(Long authorId);
}
