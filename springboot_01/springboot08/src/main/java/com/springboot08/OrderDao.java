package com.springboot08;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {

	@Cacheable(value="order", key="'.id.'+#id")
	public Order get(String id) {
		Order order = new Order();
		order.setId(id);
		order.setNo("No.0001");
		order.setDate(new Date());
		order.setQuantity(123);
		return order;
	}
}
