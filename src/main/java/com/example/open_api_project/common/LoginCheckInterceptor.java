package com.example.open_api_project.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 세션 조회 (false: 없으면 null 반환)
        HttpSession session = request.getSession(false);

        // 로그인 여부 확인 (세션이 있고, 그 안에 "user" 정보가 있어야 함)
        if (session != null && session.getAttribute("user") != null) {
            return true;
        }

        // REST API 요청인지 확인
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/api/")) {
            // API 요청이면 401 Unauthorized 에러를 JSON으로 응답
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"error\": \"Unauthorized\", \"message\": \"로그인이 필요합니다.\"}");
            return false;
        }

        response.sendRedirect("/login");
        return false;
    }
}