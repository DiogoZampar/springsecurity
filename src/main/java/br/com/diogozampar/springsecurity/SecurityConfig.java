package br.com.diogozampar.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        
        return httpSecurity
        .authorizeHttpRequests( authorizeConfig -> {
            authorizeConfig.requestMatchers("/public").permitAll();
            authorizeConfig.requestMatchers("/logout").permitAll();
            authorizeConfig.anyRequest().authenticated();
        })
        .formLogin(Customizer.withDefaults())
        .build();
    }



}