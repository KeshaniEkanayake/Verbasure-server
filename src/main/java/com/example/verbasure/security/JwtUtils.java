package com.example.verbasure.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.example.verbasure.models.UserModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
    @Value("${verbasure.app.jwtSecret}")
    private String jwtSecret;
    @Value("${verbasure.app.jwtExpirationMs}")
    private long jwtExpirationMs;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "verbasure");
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    // method to convert the server secret to a key
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.jwtSecret));
    }

    public String generateJwtToken(String username) {
        return Jwts.builder().subject(username).signWith(getSigningKey()).compact();// username is the subject of the
                                                                                    // token
    }

    // generates a cookie with the jwt token
    public ResponseCookie generateCookieWithJwtToken(UserModel user) {
        String token = generateJwtToken(user.getUsername());
        return ResponseCookie.from("verbasure", token).httpOnly(true).maxAge(this.jwtExpirationMs).path("/verbasure")
                .build();
    }

    // method to get the username from the token
    public String getUserNameFromToken(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    // method to check if the token is valid
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            // log the exception
            System.out.println(e.getMessage());
        }
        return false;
    }

}
