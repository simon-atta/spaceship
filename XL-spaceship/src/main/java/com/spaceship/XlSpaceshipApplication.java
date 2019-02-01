package com.spaceship;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spaceship.services.BoardService;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.*" })
public class XlSpaceshipApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(XlSpaceshipApplication.class, args);
		context.getBean(BoardService.class).initializeGrid();
		
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("spaceship").apiInfo(apiInfo()).select()
				.paths(regex("/xl-spaceship/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spaceship API")
				.description("Spaceship API help for commincate between spaceships").contact("Simon Ghobreil")
				.version("1.0").build();
	}
}
