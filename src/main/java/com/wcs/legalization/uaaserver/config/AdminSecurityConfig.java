package com.wcs.legalization.uaaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/admin/**")
			.addFilter(getDigestAuthFilter())
			.exceptionHandling()
			.authenticationEntryPoint(getDigestEntryPoint())
			.and().authorizeRequests().antMatchers("/admin/**")
			.hasRole("ADMIN");
	}

	public DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
		DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
		digestFilter.setUserDetailsService(userDetailsServiceBean());
		digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
		//digestFilter.setPasswordAlreadyEncoded(true);
		digestFilter.setCreateAuthenticatedToken(true);
		return digestFilter;
	}

	private DigestAuthenticationEntryPoint getDigestEntryPoint() {
		DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
		entryPoint.setRealmName("admin-digest-realm");
		entryPoint.setKey("fjkf33DD312+_");
		return entryPoint;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER")
		.and()	
			.withUser("admin")
			.password("password")
			.roles("ADMIN");
	}
	
	@Override
	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
