package com.unfrost.admin.config;

import com.unfrost.admin.service.UserService;
import com.unfrost.admin.utils.PasswordEncoderUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-09 08:20
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation()
                .migrateSession()
                // 只允许有一个活跃的session
                .maximumSessions(1)
                .and()
                .invalidSessionUrl("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/auth/**",
                        "/user/time-out",
                        "/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/swagger-ui/#/")
                .and()
                .headers().cacheControl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(PasswordEncoderUtils.getInstanceEncoder());
    }
}
