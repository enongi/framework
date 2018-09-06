package com.springboot07;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Order {
	private String id;
	
	@NotNull
	@Size(min=6, max=16)
	private String no;
	
	@NotNull
	private Date date;
	
	@Min(100)
	@NotNull
	private Integer quantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", no=" + no + ", date=" + date + ", quantity=" + quantity + "]";
	}
	
}
