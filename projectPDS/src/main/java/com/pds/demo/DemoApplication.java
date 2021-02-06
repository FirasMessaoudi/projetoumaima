package com.pds.demo;

import com.pds.demo.domains.Role;
import com.pds.demo.domains.Utilisateur;
import com.pds.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@SpringBootApplication
@EnableSwagger2
public class DemoApplication implements CommandLineRunner {
  @Autowired
  private UtilisateurService utilisateurService;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.pds.demo")).build();
    }

    @Override
    public void run(String... args) throws Exception {
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail("firas_messaoudi@outlook.fr");
//        utilisateur.setPassword("admin");
//        utilisateur.setRole(Role.Administrateur);
//        utilisateurService.save(utilisateur);
    }
}
