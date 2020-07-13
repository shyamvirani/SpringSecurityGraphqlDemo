package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long orderId;
	
	private String orderProceed;
	@JsonIgnore
	private  Integer amount;
	private  Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderedby", nullable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "orderedbook", nullable = false, updatable = false)
	private Book book;
	

	public OrderDetail() {
		super();
	}

	public OrderDetail(Long orderId, String orderProceed, Integer amount, Integer quantity, User user,Book book) {
		super();
		this.orderId = orderId;
		this.orderProceed = orderProceed;
		this.amount = amount;
		this.quantity = quantity;
		this.book=book;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderProceed() {
		return orderProceed;
	}

	public void setOrderProceed(String orderProceed) {
		this.orderProceed = orderProceed;
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	


	

}
