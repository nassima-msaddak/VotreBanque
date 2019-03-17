package org.sid.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration  // c'est une classe de configuration de securité (configuration de spring security )
@EnableWebSecurity  // Pour activer la securité web
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
 
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	/*
	auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER"); 
	 */
	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal,password as credentiels,active from users where username=?")
	.authoritiesByUsernameQuery("select username as principal,roles as role from users_roles where username=?")
	.rolePrefix("ROLE_")
	.passwordEncoder(new Md5PasswordEncoder());
}
	
	
@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		 http.formLogin().loginPage("/login");
		 
		 http.authorizeRequests().antMatchers("/operations","/consultercompte").hasRole("USER");
	
		 http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");

		 http.exceptionHandling().accessDeniedPage("/403");
}	



}
