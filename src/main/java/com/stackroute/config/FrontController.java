package com.stackroute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.stackroute")
public class FrontController {
	
	@Bean
	public InternalResourceViewResolver getResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/views/");
		view.setSuffix(".jsp");
		return view;
	}
	

}
