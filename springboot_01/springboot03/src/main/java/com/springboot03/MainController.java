package com.springboot03;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "LiZheng");
		return "index";
	}
	
	@GetMapping("/jquery")
	public String jquery() {
		return "jquery";
	}
	
	@GetMapping("angularjs")
	public String angularjs() {
		return "angularjs";
	}
	
	@PostMapping("postData")
	public @ResponseBody Map<String, Object> postData(String no, String date, int quantity){
		System.out.println("no:" + no);
		System.out.println("date:" + date);
		System.out.println("quantity:" + quantity);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "OK");
		map.put("no", no);
		map.put("date", date);
		map.put("quantity", quantity);
		return map;
	}
/*	这里，“date”参数我使用的是String类型，而并不是Date类型。
	因为大多数情况是使用对象形式来接收ajax客户端的值，所以我这里偷懒了，就直接使用String类型。
	如果想使用Date类型，则需要使用@InitBinder注解  	*/
	
	@PostMapping("postJson")
	public @ResponseBody Map<String, Object> postJson(@RequestBody Order order) {
		System.out.println("order no:" + order.getNo());
		System.out.println("order quantity:" + order.getQuantity());
		System.out.println("order date:" + order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "OK");
		map.put("value", order);
		return map; 
	}
}
