package com.spaceship.user;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.*" })
public class XlSpaceshipUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(XlSpaceshipUserApplication.class, args);
	}
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("user").apiInfo(apiInfo()).select()
                .paths(regex("/xl-spaceship/.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("User Protocal API")
                .description("User Protocal API help for commincate between users").contact("Simon Ghobreil")
                .version("1.0").build();
    }
}
