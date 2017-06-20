package org.k0r0pt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SampleSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure for HttpSecurity has been invoked.");
		http.authorizeRequests().antMatchers("/login/**").access("hasRole('SUPERMAN')").
		and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Configure for AuthenticationManagerBuilder has been invoked.");
		auth.inMemoryAuthentication().withUser("myUser").password("password").roles("SUPERMAN");
	}
}