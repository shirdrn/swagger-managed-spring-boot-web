package org.shirdrnm.platform.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class WebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();
    }

    @Component
    @Primary
    public class CustomObjectMapper extends ObjectMapper {
       
		private static final long serialVersionUID = 1L;

		public CustomObjectMapper() {
            setSerializationInclusion(JsonInclude.Include.NON_NULL);
            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            enable(SerializationFeature.INDENT_OUTPUT);
        }
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Springfox petstore API")
            .description("description")
            .contact(new Contact("name", "url", "email"))
            .license("Apache License Version 2.0")
            .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
            .version("2.0")
            .build();
    }
}