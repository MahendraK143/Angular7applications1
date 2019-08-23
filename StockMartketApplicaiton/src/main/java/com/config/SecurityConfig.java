package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        System.out.println("asdhhhjhgjg");

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/stock-list").permitAll()
        .anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint()).and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {
        System.out.println("asdfasdfasdfasf");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password");
    }
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint =
                new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("admin realm");
        return entryPoint;
    }
}