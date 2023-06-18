package com.apps.training.todos.security;

import com.apps.training.todos.entity.SecUser;
import com.apps.training.todos.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class BasicSecurity {
    @Autowired
    private SecUserService userService;
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() throws Exception {
        List<UserDetails> users = new ArrayList<>();
        List<SecUser> usersList = userService.findAllUsers();
        usersList.stream().forEach(u -> {
                                          List<GrantedAuthority> authority = new ArrayList<>();
                                          authority.add(new SimpleGrantedAuthority(u.getRoleName()));
                                          User user = new User(u.getUserName(), u.getPassword(),authority);
                                          users.add(user);
                                         });
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/welcome").authenticated()
                .requestMatchers("/users-list","/users/**", "/todos-list", "/todos/**","/welcome").hasAuthority("Admin")
                .requestMatchers("/todos-list","/todos/**", "/welcome").hasAuthority("Employee")
                .requestMatchers("/mgr", "/welcome").hasAuthority("MANAGER")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .defaultSuccessUrl("/",true)

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
        ;
        return http.build();
    }

}
