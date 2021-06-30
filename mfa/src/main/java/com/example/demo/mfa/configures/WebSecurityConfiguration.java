package com.example.demo.mfa.configures;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/i18n/**")
                .mvcMatchers("/static/**")
                .mvcMatchers("/css/**")
                .mvcMatchers("/js/**")
                .mvcMatchers("/images/**");
    }

    private String permitalUrl = "/login,/,/prelogin,/mfator,/purelogin";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable();

        http.headers().frameOptions().sameOrigin()
                .and().authorizeRequests().antMatchers(permitalUrl.split(",")).permitAll()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutUrl("/logout").invalidateHttpSession(false).permitAll()
                .and().authorizeRequests().anyRequest().authenticated();

        super.configure(http);
    }
}