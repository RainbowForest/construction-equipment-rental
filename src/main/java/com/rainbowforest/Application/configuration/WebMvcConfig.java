package com.rainbowforest.Application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.rainbowforest.Application.controller")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp()
				.prefix("/WEB-INF/jsp/")
				.suffix(".jsp");
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/statics/**");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
