package com.spaceship.protocal;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableAsync
@Configuration
@ComponentScan(basePackages = { "com.*" })
public class XlSpaceshipProtocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(XlSpaceshipProtocalApplication.class, args);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("spaceship").apiInfo(apiInfo()).select()
                .paths(regex("/xl-spaceship/.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spaceship Protocal API")
                .description("Spaceship Protocal API help for commincate between spaceships").contact("Simon Ghobreil")
                .version("1.0").build();
    }
}
