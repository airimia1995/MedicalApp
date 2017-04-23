package com.appMedial.jsp.bussines.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;



/*
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("ian").password("ian").roles("USER");
    auth.inMemoryAuthentication().withUser("dan").password("dan").roles("USER");
    auth.inMemoryAuthentication().withUser("chris").password("chris").roles("USER");
  }
}*/
@Configuration
@EnableWebSecurity
@RestController
@ComponentScan(basePackageClasses = SecurityService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	  private static final Log log = LogFactory.getLog(SecurityConfig.class);

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(securityService);//.passwordEncoder(passwordEncoder());
	    }
//	    @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	      auth.inMemoryAuthentication().withUser("ian").password("ian").roles("USER");
//	      auth.inMemoryAuthentication().withUser("dan").password("dan").roles("USER");
//	      auth.inMemoryAuthentication().withUser("chris").password("chris").roles("USER");
//	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.httpBasic().and()
	                .authorizeRequests()
	                .antMatchers("/","userLogin").permitAll()
	                .antMatchers("/addPacient","/reteta-*").hasAuthority("medic")
	                .antMatchers("/welcome","/chat").hasAnyAuthority("medic","pacient")
	                .and()
	                .formLogin().loginPage("/userLogin")
	                .defaultSuccessUrl("/welcome", true)
	                .usernameParameter("emailLOG").passwordParameter("passwordLOG")
	                .and()
	                .logout().logoutUrl("/logout").logoutSuccessUrl("/userLogin")
	                .and().csrf().disable();
	    }
}
