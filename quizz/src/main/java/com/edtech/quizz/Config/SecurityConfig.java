// package com.edtech.quizz.Config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import com.ONE4ALL.MFU_Canteen.Service.*;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     private final CustomOAuth2UserService customOAuth2UserService;

//     public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
//         this.customOAuth2UserService = customOAuth2UserService;
//     }
    
//     @Autowired      
//     private CustomLoginSuccessHandler customLoginSuccessHandler;
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/register", "/login", "/styles/**", "/images/**", "/icons/**").permitAll()
//                 .requestMatchers("/user/**").authenticated()
//                 .anyRequest().permitAll()
//             ).oauth2Login(oauth2login -> oauth2login
//             .loginPage("/login")
//             .userInfoEndpoint()
//             .userService(customOAuth2UserService)
//             .and()
//             .successHandler((request, response, authentication) -> {
//                 //CustomOAuth2UserService oauthservice = (CustomOAuth2UserService) authentication.getPrincipal();
//                 CustomOAuth2User customUser = (CustomOAuth2User) authentication.getPrincipal();
//                 Long userId = customUser.getId(); 
//                 String redirectUrl = "/user/" + userId + "/home";
//                 response.sendRedirect(redirectUrl);
//             })
//              ) 
//             .formLogin(form -> form
//                 .loginPage("/login")
//                 .successHandler(customLoginSuccessHandler) 
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout")
//                 .permitAll()
//             )
//             //Not necessary But user will only need to login again after they have logged out
       
//         //     .rememberMe(rememberMe -> rememberMe
//         //     .key("uniqueAndSecretKey") 
//         //     .rememberMeParameter("remember-me")
//         //     // .tokenValiditySeconds(86400) 
//         //     .alwaysRemember(true) 
//         // );
//             ;
//         return http.build();
//     }
// }
