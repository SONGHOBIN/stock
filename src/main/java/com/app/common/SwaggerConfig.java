package com.app.common;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private String version;
    private String title;
    
    @Bean
    public Docket stockApi() { 
    	Predicate<String> predicate=s->{
			return s.contains("/stock");
		};
		
    	version = "V1";
        title = "Stock API " + version;
    	
        return new Docket(DocumentationType.SWAGGER_2)
    		.useDefaultResponseMessages(false)
    		.groupName("stock")
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.app.stock.controller"))
			.paths(predicate)
			.build()
			.apiInfo(apiInfo(title, version));
      }
    
    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo(String title, String version) {
		return new ApiInfoBuilder()
			.title("Stock API")
			.version("1.0.0")
			.license("Apache 2.1")
			.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
			.build();
    }
    
}
