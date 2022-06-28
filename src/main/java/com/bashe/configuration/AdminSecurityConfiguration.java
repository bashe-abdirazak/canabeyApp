package com.bashe.configuration;

import com.bashe.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable();
		
		httpSecurity.antMatcher("/admin/**")
					.authorizeRequests()
					.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")					
					.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error= true")
					.usernameParameter("username").passwordParameter("password")
					.and()
					.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
					.deleteCookies("JSESSIONID")
					.and()
					.exceptionHandling();
	}



	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**", "/productImages/**", "/css/**", "/js/**", "/error/**");
	}
}
