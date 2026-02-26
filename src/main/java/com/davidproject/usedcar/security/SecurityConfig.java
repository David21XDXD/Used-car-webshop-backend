package com.davidproject.usedcar.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.CrossOriginResourcePolicyHeaderWriter;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(1)
    SecurityFilterChain uploadsChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/uploads/**", "/favicon.ico")
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {})
                .headers(h -> h
                        .crossOriginResourcePolicy(corp ->
                                corp.policy(CrossOriginResourcePolicyHeaderWriter.CrossOriginResourcePolicy.CROSS_ORIGIN)
                        )
                )
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain apiChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/public/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/cars/all", "/favicon.ico").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}))
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation("https://dev-qxpiaj7nftetek0r.us.auth0.com/");
    }
}
