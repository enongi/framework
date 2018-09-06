package com.springboot06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;

@Repository
@Transactional(readOnly=false, rollbackFor=Throwable.class)
public class OrderDao {
	@Autowired
	OrderRepository orderRepository;
	
	/**
	 * 获取全部
	 * @return
	 */
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	/**
	 * 持久化
	 * @param entity
	 * @throws Exception
	 */
	public void save(Order entity) throws Exception {
		//持久化
		orderRepository.save(entity);
		//如果持久化成功就抛出异常，如果开启事务，那么刚才持久化的数据就应该回滚
		if (!StringUtils.isNullOrEmpty(entity.getId())) {
			throw new Exception("测试无法持久化第一条数据的异常");
		}
	}
}
