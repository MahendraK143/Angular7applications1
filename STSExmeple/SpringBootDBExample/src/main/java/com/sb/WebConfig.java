package com.sb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * By default Spring Boot will serve static content from a directory called /static (or /public or /resources or /META-INF/resources) 
 * in the classpath or from the root of the ServletContext. But here we have defined out custom folder structure for static contents, 
 * hence it is required to tell Spring boot about how to render static content.
 * */
@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/*.css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/*.img/**").addResourceLocations("/resources/img/");
	}

}