package com.AuthSphereClient.AuthSphere_Client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/favicon.ico",
                    "/default-ui.css",
                    "/error",
                    "/.well-known/appspecific/**"
                ).permitAll()
                .anyRequest().authenticated()
            )

            .oauth2Login(oauth -> oauth
                .successHandler((request, response, authentication) -> {

                    System.out.println("========== OAUTH SUCCESS ==========");
                    System.out.println("Authenticated user: "
                            + authentication.getName());

                    System.out.println("Session ID: "
                            + request.getSession(false).getId());

                    System.out.println("===================================");

                    response.sendRedirect("/");
                })
            );

        return http.build();
    }
}