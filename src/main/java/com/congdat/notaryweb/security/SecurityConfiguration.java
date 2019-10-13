package com.congdat.notaryweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		private CustomUserDetailService userDetailsService;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable()
												// create 1 endpoint, allow all access -> to login -> and return JWT token :D
//												.addFilterAfter(new JWTAuthentication(), UsernamePasswordAuthenticationFilter.class)
												.authorizeRequests()
												.antMatchers("/").hasAnyRole("ROLE_USER")
												.anyRequest().authenticated()
												.and()
												.httpBasic().disable();
		}
}
