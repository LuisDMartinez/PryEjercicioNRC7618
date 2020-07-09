package com.martinez.ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		
		BCryptPasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password -> {
			return encoder.encode(password);
		});
		
		build.inMemoryAuthentication()
			.withUser(users.username("admin").password("12345").roles("ADMIN"))
			.withUser(users.username("estudiante").password("12345").roles("USER"));
		
		
	}
	@Override //Autorization
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().antMatchers("/","/css/**","/img/**","/js/**","/scss/**","/vendor/**").permitAll()
								.antMatchers("/materia/**").hasAnyRole("ADMIN")
								.antMatchers("/alumno/**").hasAnyRole("USER")
								.and()
								.formLogin().permitAll().and().logout().permitAll()
								.and().exceptionHandling().accessDeniedPage("/error_403");
				
								
		
	}
	
}
