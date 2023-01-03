package br.com.alef.mudi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/home/**").permitAll()
		.anyRequest()
		.authenticated().
		and().
		formLogin(form -> form
		.loginPage("/login")
		.defaultSuccessUrl("/usuario/pedido", true)
		.permitAll()
		
		)
		
		.logout(logout -> {
			logout.logoutUrl("/logout").logoutSuccessUrl("/home");
		})
		.csrf().disable();
		
		return http.build(); 
		
	}
	
	
	@Autowired

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		
//		UserDetails user =
//				 User.builder()
//					.username("alef")
//					.password(encoder.encode("alef"))
//					.roles("ADM")
//					.build();
		
		
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(encoder);
				

	}
}
