package com.eShop.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eShop.entity.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		auth
			.inMemoryAuthentication()
			.withUser("admin")
				.password((encoder.encode("adminpass")))
				.roles("ADMIN", "USER")
			.and().withUser("user")
				.password((encoder.encode("userpass")))
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		
		http
			.authorizeRequests()
			.antMatchers("/admins").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMINS","USER");
	}
}
