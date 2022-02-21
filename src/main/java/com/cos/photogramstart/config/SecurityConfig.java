package com.cos.photogramstart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf 비활성화
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/","/user/**","./image/**","/subscribe/**","/comment/**")
            .authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/auth/signin") //get (로그인 요청이 필요하면)
            .loginProcessingUrl("/auth/signin") // post (로그인을 요청하면)
            .defaultSuccessUrl("/");
    }

}
