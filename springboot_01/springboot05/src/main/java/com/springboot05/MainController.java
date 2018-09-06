package com.springboot05;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	OrderRepository orderRepository;
	/**
	 * 处理日期类型
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/**
	 * 持久化
	 * @param entity
	 * @return
	 */
	@PostMapping("/save")
	public @ResponseBody Map<String, Object> save(@RequestBody Order entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		entity = orderRepository.save(entity);
		result.put("id", entity.getId());
		return result;
	}
	
	/**
	 * 获取对象
	 * @param id
	 * @return
	 */
	@PostMapping("/get")
	public @ResponseBody Object get(String id) {
		return orderRepository.findOne(id);
	}
	
	/**
	 * 获取全部
	 * @return
	 */
	@PostMapping("/findAll")
	public @ResponseBody Object findAll() {
		return orderRepository.findAll();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@PostMapping("/delete")
	public @ResponseBody Map<String, Object> delete(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		orderRepository.delete(id);
		result.put("id", id);
		return result;
	}
	
	/**
	 * like查询
	 * @param no
	 * @return
	 */
	@PostMapping("/findAllByNoLike")
	public @ResponseBody Object findAllByNoLike(@RequestParam String no) {
		return orderRepository.findAllByNoLike("%" + no + "%");
	}
	
	/**
	 * between查询
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@PostMapping("/findAllByDateBetween")
	public @ResponseBody Object findAllByDateBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
		return orderRepository.findAllByDateBetween(startDate, endDate);
	}
	
	/**
	 * 小于查询
	 * @param quantity
	 * @return
	 */
	@PostMapping("/findAllbyQuantityLessThan")
	public @ResponseBody Object findAllByQuantityLessThan(int quantity) {
		return orderRepository.findAllByQuantityLessThan(quantity);
	}

}
