package com.jiochem.carsproject.config;


import com.jiochem.carsproject.Services.SpringAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SpringAuthService springAuthService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(
                (request)->
                        request
                                .requestMatchers("/login", "/register", "error/**", "/js/**", "css/**","upload/**", "assets/**", "/").permitAll()
                                .requestMatchers("/admin").hasAuthority("ADMIN")
                                .requestMatchers("/reservations/**").hasAuthority("USER")
                                .anyRequest().authenticated()
                ).formLogin((login)->
                        login.loginPage("/login").permitAll())
                .logout((logout)-> logout.logoutUrl("/logout"));

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(springAuthService);

        return daoAuthenticationProvider;
    }
}
