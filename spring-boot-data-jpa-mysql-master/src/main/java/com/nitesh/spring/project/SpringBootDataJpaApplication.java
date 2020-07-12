package com.nitesh.spring.project;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//https://bezkoder.com/spring-boot-jpa-crud-rest-api/
@SpringBootApplication
@EnableSwagger2
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Bean
	public Docket api() {                
		return new Docket(DocumentationType.SWAGGER_2)          
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nitesh"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo())
				.globalOperationParameters(
						Arrays.asList(new ParameterBuilder()
								.name("Authorization")
								.description("Autorization header")
								.modelRef(new ModelRef("string"))
								.parameterType("header")
								.required(false)
								.build()))
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Policy REST API", 
				"Rest API to update Policy Details", 
				"API", 
				"Terms of service", 
				new Contact("Nitesh shetty", "www.nitesh.com", "niteshshetty91@yahoo.in"), 
				"License of API", "API license URL", Collections.emptyList());
	}


}


