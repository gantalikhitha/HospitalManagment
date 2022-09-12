package com.project.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(this.getUserDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
        .authorizeRequests().antMatchers("/welcome","/registration","/patients").permitAll()
        .antMatchers("/user/**").hasRole("USER")
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/do/**").hasRole("DOCTOR")
        .antMatchers("/**")
        .permitAll()
        .and()
        .formLogin()
				
				
				  .loginPage("/hos/user") .failureUrl("/hos/user?error")
				  .loginProcessingUrl("/getlogin") .defaultSuccessUrl("/user/userhome")
				 
				 
				
				
				  .loginPage("/hos/admin") .loginProcessingUrl("/getlogin")
				  
		          .defaultSuccessUrl("/adminhome")
				 
				  .and()
					 
			        .csrf().disable();
	
		
		
	    
		  
		 	
	}
	    
}
