package com.nozha.etudiant.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;

 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	 PasswordEncoder passwordEncoder = passwordEncoder ();
	 
	 
	 auth.userDetailsService(userDetailsService)
	 .passwordEncoder(passwordEncoder);
	 
	 
	
 }


 @Override
 protected void configure(HttpSecurity http) throws Exception {
	 
	 http.exceptionHandling().accessDeniedPage("/accessDenied");
	 
	 http.authorizeRequests().antMatchers("/showCreate","/showCreate1").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/saveEnseignant","/saveSpecilate").hasAnyRole("ADMIN","AGENT");
	 http.authorizeRequests().antMatchers("/ListeEnseignants")
	 .hasAnyRole("ADMIN","AGENT","USER");
	 
	 

	 http.authorizeRequests()
	 .antMatchers("/supprimerEnseignant","/modifierEnseignant","/updateEnseignant","/supprimerSpecilate","/modifierSpecilate","/updateSpecilate")
	 .hasAnyRole("ADMIN");

	 http.authorizeRequests().antMatchers("/login").permitAll();
	 
	 http.authorizeRequests().antMatchers("/webjars/**").permitAll();
	 
	 http.authorizeRequests().anyRequest().authenticated();
	 
	 http.formLogin().loginPage("/login");
 }
 
 @Bean
 public PasswordEncoder passwordEncoder () {
 return new BCryptPasswordEncoder();
 }
}