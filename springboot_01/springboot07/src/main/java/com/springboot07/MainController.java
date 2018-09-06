package com.springboot07;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/save")
	public @ResponseBody Map<String, Object> save() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "ok");
		return result;
	}
	
	@PostMapping("/saveOrder")
	public @ResponseBody Map<String, Object> saveOrder(@RequestBody @Valid Order order){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "ok");
		result.put("order", order);
		return result;
	}
}
