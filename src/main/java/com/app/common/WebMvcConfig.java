package com.app.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
//    @Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs?group=stock"); // 주식
//		registry.addRedirectViewController("/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
//		registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
//	}
}
