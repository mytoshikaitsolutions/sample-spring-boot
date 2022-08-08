package com.alpha.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("alpha-api")
				.pathsToMatch("/api/**")
				.build();
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${alphaApi.doc.version}") String appVersion) {
		return new OpenAPI()
				.addServersItem(new Server().url("/"))
				.info(new Info()
						.title("Alpha API")
						.version(appVersion)
						.description("This is AlphaApi server.")
						.termsOfService("http://alpha-api/terms/")
						.license(new License().name("alphaApi").url("http://alpha-api.org")));
	}
}
