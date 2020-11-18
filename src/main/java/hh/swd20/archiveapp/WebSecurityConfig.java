package hh.swd20.archiveapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.swd20.archiveapp.web.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			//archivessets and archives can be viewed without logging in.
			//bad practice in real life especially if some data would be sensitive, but for a demo-project like this, it's good to easily view the data
			//in this case the data is pseudorandom, not real and serves the purpose for being just a demonstration
			.antMatchers("/archivesets", "/archives").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			//login-page is found from the endpoint login
			.loginPage("/login")
			.permitAll()
			//on succesful login, redirect to the endpoint below
			.defaultSuccessUrl("/archives/add", true)
			.and()
			.logout()
			.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
