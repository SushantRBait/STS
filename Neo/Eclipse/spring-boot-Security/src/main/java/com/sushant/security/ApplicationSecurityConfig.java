package com.sushant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.sushant.security.ApplicationUserRole.STUDENT;
import static com.sushant.security.ApplicationUserRole.ADMIN;
import static com.sushant.security.ApplicationUserRole.ADMINTRAINEE;
import static com.sushant.security.ApplicationUserPermission.COURSE_WRITE;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.csrf().disable()   //CSRF stands for Cross-Site Request Forgery. It is an attack that forces an end user to execute unwanted actions on a web application in which they are currently authenticated.
			.authorizeRequests()
			.antMatchers("/","index","/css/*","/js/*").permitAll()
			.antMatchers("api/**").hasRole(STUDENT.name())
			.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.name())
			.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.name())
			.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.name())
			.antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails SushantUser=User.builder()
				.username("Sushant")
				.password(passwordEncoder.encode("password"))
				.roles(STUDENT.name())   //ROLE_STUDENT
				.build();
		
		UserDetails RamUser=User.builder()
				.username("Ram")
				.password(passwordEncoder.encode("password123"))
				.roles(ADMIN.name())   //ROLE_ADMIN
				.build();
		
		UserDetails SharadUser=User.builder()
				.username("Sharad")
				.password(passwordEncoder.encode("password123"))
				.roles(ADMINTRAINEE.name())   //ROLE_ADMINTRAINEE
				.build();
	
		return new InMemoryUserDetailsManager(SushantUser,RamUser,SharadUser);
	}
}
