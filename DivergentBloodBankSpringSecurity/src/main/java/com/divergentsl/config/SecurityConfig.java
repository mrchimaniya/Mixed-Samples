package com.divergentsl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("admin")
		    .password(passwordEncoder.encode("111"))
		    .roles("ADMIN")
		    .and() // using and() you can define multiple user
		    .withUser("donor")
	       .password("222")
	       .roles("USER");
	 }
	 
	@Bean
	public PasswordEncoder getPasswordEncode()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	       .antMatchers("/admin/**").hasRole("ADMIN")  // ** means all request after /admin/--/--- anything
	      //.antMatchers("/donor/userlogin").hasAnyRole("USER","ADMIN")
	       .antMatchers("/").permitAll()
	       .and()
	       .formLogin();
	}
}
