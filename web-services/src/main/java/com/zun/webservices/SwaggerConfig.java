package com.zun.webservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Ranga Karanam",
            "https://courses.in28minutes.com/", "in28minutes@gmail.com");
    private static final ApiInfo DEFAULT_API_INFO =
            new ApiInfoBuilder().title("Awesome API Title").description("Awesome API Description").version("1.0")
    .termsOfServiceUrl("urn:tos").contact(DEFAULT_CONTACT).license("Apache 2.0")
    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").build();

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            Arrays.asList(
                    "application/json", "application/xml"
            )
    );

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

}
