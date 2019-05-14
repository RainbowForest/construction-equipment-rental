package com.rainbowforest.Application.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT user_name , user_password, user_enabled FROM users WHERE user_name=?")
		.authoritiesByUsernameQuery("SELECT user_name, user_role FROM users INNER JOIN authorities ON users.user_role_id = authorities.id WHERE user_name=?");


	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.usernameParameter("userName")
			.passwordParameter("userPassword")
			.permitAll()
			.successForwardUrl("/")
			.and().logout().permitAll()
			.and()
			.csrf().disable();
		
	
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/img/");
		super.configure(web);
	}
	
	
}
