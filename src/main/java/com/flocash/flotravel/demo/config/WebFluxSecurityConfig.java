package com.flocash.flotravel.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;


//@Configuration
//@EnableWebFluxSecurity
//public class WebFluxSecurityConfig {
//
//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails sAdmin = User
//                .withUsername("sAdmin")
//                .password("Flocash@123")
////                .password(encoder().encode("password"))
//                .roles("SADMIN")
//                .build();
//
//        UserDetails admin = User
//                .withUsername("admin")
//                .password("Flocash@123")
////                .password(encoder().encode("password"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User
//                .withUsername("user")
//                .password("Flocash@123")
////                .password(encoder().encode("password"))
//                .roles("USER")
//                .build();
//
//        return new MapReactiveUserDetailsService(sAdmin, admin, user);
//    }
//
//    @Bean
//    public SecurityWebFilterChain webSessionSpringSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange()
//                .anyExchange().authenticated()
//                .and()
//                .httpBasic()
//                .securityContextRepository(new WebSessionServerSecurityContextRepository())
//                .and()
//                .formLogin();
//
//        http.csrf().disable();
//
//        return http.build();
//
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
