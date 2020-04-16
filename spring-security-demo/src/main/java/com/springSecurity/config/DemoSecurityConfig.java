package com.springSecurity.config;

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
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	/*Method use to define Role of user and also provide default login page*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
		.withUser("john").password(passwordEncoder.encode("123456")).roles("EMPLOYEE").and()
		.withUser("mary").password(passwordEncoder.encode("123456")).roles("EMPLOYEE","MANAGER").and()
		.withUser("raj").password(passwordEncoder.encode("123456")).roles("EMPLOYEE","ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*Method use to define custom login page url,logout,and access as per role features*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*If user has allowed to access each thing*/
	/*	http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showLoginPage")
				.loginProcessingUrl("/login").permitAll().and().logout().permitAll();*/
		
	/*	Access based on Role*/
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/showLoginPage")
		.loginProcessingUrl("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
