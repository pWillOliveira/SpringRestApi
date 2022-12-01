package com.web.api.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private Contact contato() {
		return new Contact("William Oliveira", "https://github.com/pWillOliveira", "polveira.william@gmail.com");
	}

	private ApiInfoBuilder infoApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Springboot Web Rest API");
		apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de Uso: Open Source");
		apiInfoBuilder.license("Licença - Sua Empresa");
		apiInfoBuilder.licenseUrl("https://github.com/pWillOliveira/SpringRestApi");
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	@Bean
	public Docket detailApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.web.api"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.infoApi().build())
				.consumes(new HashSet<>(Arrays.asList("application/json")))
				.produces(new HashSet<>(Arrays.asList("application/json")));

		return docket;

	}


}
