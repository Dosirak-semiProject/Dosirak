package com.ohgiraffers.dosirak.config.handler;

import com.ohgiraffers.dosirak.common.UserRole;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.net.URLEncoder;

// 참고 : https://dkyou.tistory.com/25

@Configuration
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        String successMessage = "";
        String sendUrl = "";

        if(UserRole.ADMIN.getRole() == "ADMIN"){
            successMessage = "관리자 로그인 성공";
            sendUrl = "/admin/main";
        } else {
            successMessage = "로그인 성공";
            sendUrl = "/user/main";
        }

        successMessage = URLEncoder.encode(successMessage, "UTF-8");

        setDefaultTargetUrl(sendUrl + "?message=" + successMessage);

        super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
