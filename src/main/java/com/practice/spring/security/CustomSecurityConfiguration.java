package com.practice.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class CustomSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.inMemoryAuthentication()
                .withUser("srinath")
                .password("password")
                .roles("ADMIN", "USER")

                .and()

                .withUser("test")
                .password("test")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
}