package com.springboot10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App10 extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App10.class, args);
        System.out.println( "Hello World!" );
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
    	return applicationBuilder.sources(App10.class);
    }
}
