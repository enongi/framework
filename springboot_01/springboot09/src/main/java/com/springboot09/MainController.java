package com.springboot09;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Value("${blog.debug}")
	private boolean debug;
	@Value("${blog.url}")
	private String url;
	@Value("${blog.year}")
	private int year;
	
	 @Value("${server.port}")
	    private int port;

    @Value("${spring.profiles.active}")
    private String active;

	
	@Autowired
	CustomerConfig customerConfig;
	
	@GetMapping("/")
	public String index(Map<String, Object> model) {
		model.put("debug", debug);
		model.put("url", url);
		model.put("year", year);
		
		model.put("info", customerConfig.getInfo());
        model.put("blogs", customerConfig.getBlogs());
        
        model.put("port", port);
        model.put("active", active);

		return "index";
	}
	
	

}
