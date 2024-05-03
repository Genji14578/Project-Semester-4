package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.example.demo.services.AccountService;

@Configuration
@EnableWebSecurity

public class SecuirityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AccountService accountService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable();
		httpSecurity.authorizeRequests()
				.antMatchers("/home**")
				.access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/super_admin/**").access("hasRole('ROLE_SUPER_ADMIN')")
				.antMatchers("/admin/invoice/**")
				.access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
				.antMatchers("/admin/comment/**")
				.access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
				.and().formLogin().loginPage("/login")
				.loginProcessingUrl("/process").defaultSuccessUrl("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID").and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder builder)
	 * throws Exception { builder.userDetailsService(accountService); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		//builder.userDetailsService(accountService);
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     builder.userDetailsService(accountService).passwordEncoder(passwordEncoder);
	}
	/* @Bean
	public HttpFirewall defaultHttpFirewall() {
		return new DefaultHttpFirewall();
	} */

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
