package org.java.lessons.spring_games_collection.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/games/create", "/games/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/games/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/games/**").hasAuthority("ADMIN")
                .requestMatchers("/platforms/create", "/platforms/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/platforms/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/platforms/**").hasAuthority("ADMIN")
                .requestMatchers("/genres/create", "/genres/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/genres/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/genres/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                .requestMatchers("/**").hasAnyAuthority("ADMIN", "USER")
                .and().formLogin().and().logout().and()
                .exceptionHandling().and().csrf().disable();

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    DatabaseUserDetailService userDetailsService() {
        return new DatabaseUserDetailService();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());

        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
