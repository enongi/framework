package com.springboot08;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	private static final String STR_REDIS_KEY = "key:name";
	
	@Autowired
	StringRedisTemplate redisTemplate;
	@Autowired
	private OrderDao orderDao;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("setString")
	public @ResponseBody Map<String, Object> setString(String value){
		redisTemplate.opsForValue().set(STR_REDIS_KEY, value);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "ok");
		return result;
	}
	
	@PostMapping("getString")
	public @ResponseBody Map<String, Object> getString(){
		String value = redisTemplate.opsForValue().get(STR_REDIS_KEY);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("value", value);
		result.put("msg", "ok");
		return result;
	}
	
	@PostMapping("/get")
	public @ResponseBody Order get(@RequestParam String id) {
	    return orderDao.get(id);
	}

}
