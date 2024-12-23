package com.tech.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configura el acceso al endpoint /create solo para el usuario 'sa'
        http
                //.csrf().disable()
                .authorizeRequests()
                .antMatchers("/challenge/v1/create").hasRole("USER") // Solo el usuario con rol 'USER' puede acceder a este endpoint
                .anyRequest().authenticated() // Requiere autenticación para otras rutas
                .and()
                .httpBasic(); // Habilita la autenticación básica
    }

    @Override
    protected UserDetailsService userDetailsService() {
        // Definir al usuario 'sa' con rol 'USER'
        return username -> {
            if ("sa".equals(username)) {
                return User.builder()
                        .username("sa")
                        .password(passwordEncoder().encode("sa123")) // Codifica la contraseña
                        .roles("USER") // Asigna el rol 'USER'
                        .build();
            }
            throw new IllegalArgumentException("Usuario no encontrado");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usamos BCrypt para la codificación de contraseñas
    }
}

