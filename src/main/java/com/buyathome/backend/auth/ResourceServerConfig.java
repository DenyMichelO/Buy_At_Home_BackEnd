package com.buyathome.backend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes","/api/usuarios").permitAll()
                .antMatchers(HttpMethod.GET, "/api/clientes/{idCliente}").hasAnyRole("ADMINISTRADOR","VENTAS")
                .antMatchers(HttpMethod.GET, "/api/usuarios/{idUsuario}").hasAnyRole("ADMINISTRADOR","VENTAS")
                .antMatchers(HttpMethod.POST,"/api/clientes").hasRole("ADMINISTRADOR")
                .antMatchers("/api/clientes/**").hasRole("ADMINISTRADOR")
        .anyRequest().authenticated();
    }
}
