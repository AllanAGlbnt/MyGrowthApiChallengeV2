package com.allanAsc.MyGrowthApiChallengeV2.admin;

import com.allanAsc.MyGrowthApiChallengeV2.user.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

/*	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider1() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());


        return authProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider1());

        http.authorizeRequests().antMatchers("/").permitAll();
        http.antMatcher("/admin/**")
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("username")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/");

    }

}
