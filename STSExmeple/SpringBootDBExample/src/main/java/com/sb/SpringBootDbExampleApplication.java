package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//SpringBootServletInitializer enables process used in Servlet 3.0 using web.xml
//@SpringBootApplication Equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootDbExampleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbExampleApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SpringBootApplication.class);
	}
}
