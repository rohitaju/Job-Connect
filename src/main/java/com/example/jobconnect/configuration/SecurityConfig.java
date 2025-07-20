package com.example.jobconnect.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin", "/add/admin", "/update/admin/**", "/delete/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**", "/job/**", "/home/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)  // redirect after login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")                        // Endpoint for logout (default: /logout)
                        .logoutSuccessUrl("/login?logout")           // Redirect after successful logout
                        .invalidateHttpSession(true)                 // Invalidate the session
                        .deleteCookies("JSESSIONID")                 // Delete cookies
                        .clearAuthentication(true)                   // Clear authentication info
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user1 = User.builder()
                .username("user1")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password(passwordEncoder.encode("user1234"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user1 , user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
