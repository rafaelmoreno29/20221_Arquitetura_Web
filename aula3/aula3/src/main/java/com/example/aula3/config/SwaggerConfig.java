package com.example.aula3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;



@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private Contact contact(){
        return new Contact("Rafael", "https://github.com/rafaelmoreno29", "rafael.moreno@facens.br");
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
        .title("Exemplo API")
        .description("API de exemplo - 5º ADS Facens")
        .version("1.0.0")
        .contact(contact())
        .build();
    }

    
}
