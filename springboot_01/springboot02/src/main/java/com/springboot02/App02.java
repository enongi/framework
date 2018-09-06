package com.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App02 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App02.class, args);
        System.out.println( "Hello World!" );
    }
}
