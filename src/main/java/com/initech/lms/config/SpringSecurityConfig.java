package com.initech.lms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
		
		
//		http.cors()
//		 .disable()
//		 .authorizeRequests()
//		 .antMatchers("/Member/Register").permitAll()
//		 .anyRequest()
//		 .authenticated()
//		 .and()
//		 .httpBasic();
		
//		http.cors().disable()
//		 .authorizeRequests()
//		 .antMatchers("/**").permitAll()
//		 .antMatchers("/").permitAll()
//		 .anyRequest().authenticated()
//		 .and()
//		 .formLogin();
		 
		
		
//		http  
//        .authorizeRequests()  
//        .anyRequest().authenticated() 
//        .and()
//        .formLogin() 
//        .and()
//        .httpBasic();  
			
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/Member/Register");
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
		
}