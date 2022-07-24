package com.weni.ecs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Component
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
    Info info = new Info().title("Emergency Control System API").version(appVersion)
            .description(" Emergency Control API입니다.")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact().name("weni").url("https://www.weni.com/").email("admin@weni.com"))
            .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));

    return new OpenAPI()
            .components(new Components())
            .info(info);
  }
}
