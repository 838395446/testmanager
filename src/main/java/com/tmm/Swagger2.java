package com.tmm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Captain Wang on 17/4/12.
 */
@Configuration
@EnableSwagger2

public class Swagger2 {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("http://localhost"))
                .apis(RequestHandlerSelectors.any())//<5>
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //.paths(Predicates.not(PathSelectors.regex("/error.*")))
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger2 APIs")
                .description("【 接口测试管理平台 】")
                .termsOfServiceUrl("www.chanjet.com")
                .contact("Captain Wang")
                .version("1.0")
                .build();
    }


}
