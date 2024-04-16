package com.ohgiraffers.dosirak.config;

import com.ohgiraffers.dosirak.common.UserRole;
import com.ohgiraffers.dosirak.config.handler.LoginFailHandler;
import com.ohgiraffers.dosirak.config.handler.LoginSuccessHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LoginFailHandler loginFailHandler;
    private final LoginSuccessHandler loginSuccessHandler;

    public SecurityConfig(LoginFailHandler loginFailHandler, LoginSuccessHandler loginSuccessHandler){
            this.loginFailHandler = loginFailHandler;
            this.loginSuccessHandler = loginSuccessHandler;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {


        /* 요청에 대한 권한 체크 */
        http.authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/user/**", "/", "/login", "/admin/**", "**").permitAll();    // 권한이 없어도 접근가능한 페이지 URL, 모든 사용자 접근가능

                    auth.requestMatchers("/admin/**").hasAnyAuthority(UserRole.ADMIN.getRole());
                    auth.requestMatchers("/user/myinfo/**").hasAnyAuthority(UserRole.USER.getRole());
                    auth.requestMatchers("/", "/login", "/loginFail", "/user/**").permitAll();
                    auth.anyRequest().authenticated();      // 그 외의 요청은 인증이 된 사용자만 사용가능
                })
                .formLogin(login -> {
                    login.loginPage("/login");     // 로그인페이지 설정
                    login.usernameParameter("id");
                    login.passwordParameter("pwd");
//                    login.defaultSuccessUrl("/user/main", true);     // 로그인 성공시 페이지 경로 설정
                    login.successHandler(loginSuccessHandler);
                    login.failureHandler(loginFailHandler);  // 실패 시 핸들러 설정
                })
                .logout(logout -> {
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                    logout.deleteCookies("JSESSIONID");
                    logout.invalidateHttpSession(true);
                    logout.logoutSuccessUrl("/");
                })
                .sessionManagement(session -> {
                    session.maximumSessions(1);     // 로그인 할수 있는 세션 개수 제한
                    session.invalidSessionUrl("/"); // 세션 만료시 이동할 페이지
                }).csrf(csrf -> csrf.disable());    // Cross-Site Request Forgery 개발단계에서만 disable() 설정해줌

        return http.build();
    }

    /* 비밀번호 암호화에 사용할 객체 BCryptPasswordEncoder bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // 비밀번호 암호화에 가장 많이 사용됨
    }
}
