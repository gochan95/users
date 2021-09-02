package com.example.users;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//csrf disabled only for this test, not good security practice in reality
            .csrf().disable()
			.authorizeRequests()
			// allow api/register and api/login to be accessed by anyone
            .antMatchers("/", "/api/register", "/api/login").permitAll()
            .anyRequest().authenticated()
            .and().httpBasic();
	}

}