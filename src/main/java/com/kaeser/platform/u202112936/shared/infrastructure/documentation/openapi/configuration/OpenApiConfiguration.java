package com.kaeser.platform.u202112936.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        // General Configuration
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Kaeser API")
                        .description("Kaeser application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Kaeser Wiki Documentation")
                        .url("https://acme-learning-platform.wiki.github.io/docs"));

        // Add security scheme

        final String securitySchemeName = "bearerAuth";

        return openApi;
    }
}
