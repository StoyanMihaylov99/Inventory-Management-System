package org.example.restdemo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {



    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password("{noop}manager123")
                .roles("MANAGER")
                .build();

        UserDetails employee = User.builder()
                .username("employee")
                .password("{noop}employee123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(admin,manager,employee);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.DELETE, "/items/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/items/**").hasAnyRole("ADMIN", "MANAGER")
                .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
