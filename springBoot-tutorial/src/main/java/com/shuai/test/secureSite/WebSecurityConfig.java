package com.shuai.test.secureSite;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {}//extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//
//                .antMatchers("/", "/home").permitAll() // these methods permit to all
//
//                .anyRequest().authenticated() // methods need to be authenticated
//
//                .and()
//
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()   //login permit to all
//
//                .and()
//                .logout()
//                .permitAll()  // logout permit to all
//                ;
//    }
//
////    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//        //you can also add lots of users to check against the input
//    }

