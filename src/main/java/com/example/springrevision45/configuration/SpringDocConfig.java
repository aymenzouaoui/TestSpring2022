package com.example.springrevision45.configuration;



        import io.swagger.v3.oas.models.OpenAPI;
        import io.swagger.v3.oas.models.info.Contact;
        import io.swagger.v3.oas.models.info.Info;
        import org.springdoc.core.models.GroupedOpenApi;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("aymen.zouaoui@esprit.tn")
                .url("https://www.instagram.com/aymenzouaoui16/");
        return contact;
    }
    @Bean
    public GroupedOpenApi BibliothequePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Bibliotheque Management API")
                .pathsToMatch("/bibliotheque/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi LivrePublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Livre  Management API")
                .pathsToMatch("/livre/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi personelPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only personel Management API")
                .pathsToMatch("/personnel/**")
                .pathsToExclude("**")
                .build();
    }

}


