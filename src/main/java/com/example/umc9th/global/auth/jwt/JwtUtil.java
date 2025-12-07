package com.example.umc9th.global.auth.jwt;

import com.example.umc9th.global.auth.userdetails.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private final Key secretKey;
    private final long accessExpirationMs;

    public JwtUtil(
            @Value("${jwt.token.secretKey}") String secret,
            @Value("${jwt.token.expiration.access}") Long accessExpirationMs
    ) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessExpirationMs = accessExpirationMs;
    }

    // AccessToken 생성
    public String createAccessToken(CustomUserDetails user) {
        return createToken(user, accessExpirationMs);
    }

    // 토큰에서 이메일(subject) 가져오기
    public String getEmail(String token) {
        try {
            return getClaims(token).getSubject();
        } catch (JwtException e) {
            return null;
        }
    }

    // 토큰 유효성 확인
    public boolean isValid(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    // 실제 토큰 생성 로직
    private String createToken(CustomUserDetails user, long expirationMs) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(user.getUsername())        // 이메일
                .claim("role", authorities)
                .claim("email", user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)                  // 0.11.5에서는 이 방식 OK
                .compact();
    }

    // 토큰 → Claims 파싱
    private Claims getClaims(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)   // 서명 & 만료 검증
                .getBody();              // Claims
    }
}
