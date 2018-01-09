package com.samson.onlineshop.config;

import com.samson.onlineshop.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("com.samson.onlineshop")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
    @Autowired
    DataSource dataSource;

    @Autowired
    PersistentTokenRepository tokenRepository;

    //Using in memory database for authentication
    /*@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER");

    }*/

    /*@SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }*/

   /* //JDBC Authentication
    //Provides default queries
    //– SELECT username, password, enabled FROM users WHERE username = ?
    //– SELECT username, authority FROM authorities WHERE username = ?
    //We can customize the default queries by using following methods
    //usersByUsernameQuery()
    //authoritiesByUsernameQuery()
    //groupAuthoritiesByUsername()
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                    .usersByUsernameQuery("select username,password,enabled from users where username=?")
                    .authoritiesByUsernameQuery("select username,role from user_roles where username=?");

    }*/

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

/*        httpSecurity.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll();*/

        httpSecurity.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");

        httpSecurity.formLogin()
                .defaultSuccessUrl("/market/products/add")
                .failureUrl("/login?error");

        httpSecurity.logout()
                .logoutSuccessUrl("/login?logout");

        httpSecurity.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");

        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**/add").access("hasRole('ADMIN')")
                .antMatchers("/**/market/**").access("hasRole('ROLE_USER')");


        httpSecurity.authorizeRequests().antMatchers("/", "/list")
                    .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                    .antMatchers("/newuser/**", "/delete-user-*").access("hasRole('ADMIN')").antMatchers("/edit-user-*")
                    .access("hasRole('ADMIN') or hasRole('DBA')").and().formLogin().loginPage("/login")
                    .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
                    .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
                    .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");

        /*Protect our app from Cross Site Request Forgery (CSRF) */
        httpSecurity.csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }
}
