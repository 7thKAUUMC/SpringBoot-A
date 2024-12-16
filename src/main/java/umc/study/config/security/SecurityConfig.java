package umc.study.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/signup", "/css/**").permitAll() // 누구나 접근 가능
                        .requestMatchers("/admin/**").hasRole("ADMIN")                  // ADMIN 권한 필요
                        .anyRequest().authenticated()                                  // 나머지 요청은 인증 필요
                )
                .formLogin((form) -> form
                        .loginPage("/login")                       // 사용자 지정 로그인 페이지
                        .defaultSuccessUrl("/home", true)          // 로그인 성공 시 리다이렉트 URL
                        .permitAll()                               // 로그인 페이지는 누구나 접근 가능
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")                      // 로그아웃 URL
                        .logoutSuccessUrl("/login?logout")         // 로그아웃 성공 시 리다이렉트 URL
                        .permitAll()                               // 로그아웃도 누구나 접근 가능
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                );

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder를 빈으로 등록
    }
}
