package com.rainbowforest.Application;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.rainbowforest.Application.configuration.DataSourceConfig;
import com.rainbowforest.Application.configuration.WebMvcConfig;
import com.rainbowforest.Application.configuration.WebSecurityConfig;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {DataSourceConfig.class, WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
