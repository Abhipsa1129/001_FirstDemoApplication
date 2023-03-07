package com.appl.demo.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic();
		http.csrf().disable();//Done to allow Basic auth for GET/POST/PUT 
		return http.build();
	}

	
	/* Used to set custom user for Basic Auth */

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {

		UserDetails user1 = User.withUsername("Abhipsa").password(this.passwordEncoder().encode("Abhi@1129"))
				.roles("USER").build();

		UserDetails user2 = User.withUsername("Ananya").password(this.passwordEncoder().encode("Ananya@1129"))
				.roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user1, user2);
	}                                             

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
		/*                                                                                                                                                                       
		 * PasswordEncoder encoder =
		 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 * 
		 * return encoder;
		 */
	}
}
