package com.demo.MySpringBoot3Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
     @Bean
     //inmemory authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin1")
                .password(encoder.encode("pass1"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("user11")
                .password(encoder.encode("pass11"))
                .roles("USER","ADMIN","HR")
                .build();
        return new InMemoryUserDetailsManager(admin, user);

      }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/hello/**").permitAll()
                        .requestMatchers("/welcome","/products/**").authenticated());

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
      @Bean
    public PasswordEncoder passwordEncoder() {

         return new BCryptPasswordEncoder();
    }


}
