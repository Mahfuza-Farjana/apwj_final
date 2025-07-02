package com.Project.LibraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(HttpMethod.GET, "/api/books/**", "/api/categories/**")
						.hasAnyRole("USER", "ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/users/**")
						.hasAnyRole("USER", "ADMIN")
						.requestMatchers("/api/**")
						.hasRole("ADMIN")
						.anyRequest()
						.authenticated()
				)
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.builder().username("user").password(passwordEncoder().encode("123456")).roles("USER").build();
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("123456")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
