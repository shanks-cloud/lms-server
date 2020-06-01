package com.initech.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
    UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {        
		http.csrf().
	        disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**")            
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService);
	}
		
		
		
//		http.cors()
//		 .and()
//		 .authorizeRequests()
//		 .antMatchers(HttpMethod.OPTIONS, "/**")
//		 .permitAll()
//		 .anyRequest()
//		 .authenticated()
//		 .and()
//		 .httpBasic();
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
		
}