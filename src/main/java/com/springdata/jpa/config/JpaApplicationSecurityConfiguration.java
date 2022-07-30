package com.springdata.jpa.config;

import com.springdata.jpa.roles.JpaApplicationRolePermission;
import com.springdata.jpa.roles.JpaApplicationRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.springdata.jpa.roles.JpaApplicationRolePermission.STUDENT_WRITE;
import static com.springdata.jpa.roles.JpaApplicationRoles.*;

@Configuration
@EnableWebSecurity
public class JpaApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JpaApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    /**
     *
     * @param http
     * @throws Exception
     * Method allow authorizeRequests any Request and Authenticate
     * Ant matcher are used to white list the url.
     * WE can define set of Role so that specific role can access the api
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index")
                .permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAnyAuthority(STUDENT_WRITE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    /**
     *  Method will give user based details for authentication.
     *  In Memory Database is used to save user details and password
     *  UserDetails are used to build user
     *  Password mapping is required and This can be achieve by password Encoder
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user= User.builder()
                .username("vipin")
                .password(passwordEncoder.encode("password123"))
                .roles(STUDENT.name())
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMIN.name())
                .build();

        UserDetails adminUserTrainee = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ADMINTRAINEE.name())
                .build();

        return new InMemoryUserDetailsManager(user,adminUser,adminUserTrainee);
    }
}
