package com.natanlf.helpdesk.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests() //prove vários tipos de segurança mas por enquanto não vou usar
		.antMatchers(HttpMethod.GET, "/").permitAll() //não precisa estar autenticado para acessar
		.anyRequest().authenticated() // qualquer outra uri precisa de autenticação
		.and().formLogin().permitAll() //dou acesso ao login do SpringBoot
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //caso acesse esse endereço então faz logout
		
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication() //autenticação em memória
		.withUser("natan").password("123").roles("ADMIN");
	}
	
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/style/**"); //para o SpringBoot não bloquear páginas estaticas
	}
}
