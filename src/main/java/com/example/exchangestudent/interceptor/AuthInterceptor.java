package com.example.exchangestudent.interceptor;

import com.alibaba.fastjson2.JSON;
import com.example.exchangestudent.config.CookieConfig;
import com.example.exchangestudent.config.JwtConfig;
import com.example.exchangestudent.model.po.User;
import com.example.exchangestudent.util.CookieUtil;
import com.example.exchangestudent.util.SessionContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private final Key key;

    @Autowired
    private CookieConfig cookieConfig;

    @Autowired
    public AuthInterceptor(JwtConfig jwtConfig) {
        // Your secret key used to sign the JWT. Consider externalizing this value.
        this.key = Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = CookieUtil.getCookieValue(request.getCookies(), cookieConfig.getName());

        if (authorization == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: No JWT provided.");
            return false;
        }

        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authorization);
            User user = JSON.parseObject(claims.getBody().getSubject(), User.class);

            SessionContext.setEmail(user.getEmail());
            SessionContext.setUserId(user.getUserId());
            SessionContext.setUserName(user.getUsername());
            return true;
        } catch (JwtException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Invalid JWT.");
            return false;
        }
    }
}
