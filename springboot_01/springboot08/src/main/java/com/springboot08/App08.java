package com.springboot08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
public class App08 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App08.class, args);
        System.out.println( "Hello World!" );
    }
    
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
    	return new StringRedisTemplate(connectionFactory);
    }
}
