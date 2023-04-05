package com.example.CRM.Customer_relationship_management.config;

import com.example.CRM.Customer_relationship_management.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().
                authorizeRequests()

                .antMatchers("/api/users/**").permitAll()

                .antMatchers("/api/products/specificProduct/{id}").hasAnyRole("CUSTOMER","ADMIN","SUPERADMIN")
                .antMatchers("/api/products/updateProduct/{id}").hasAnyRole("SUPERADMIN","ADMIN")
                .antMatchers("/api/products/deleteProduct/{id}").hasAnyRole("SUPERADMIN","ADMIN")
                .antMatchers("/api/products/all").hasAnyRole("CUSTOMER","ADMIN","SUPERADMIN")
                .antMatchers("/api/products/addnewproduct").hasAnyRole("SUPERADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
    }
}
