package com.java.bytecupidsbackend.infrastructure.security;

import com.java.bytecupidsbackend.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

    private final String jwtSecret = "raf7uBYXg+FwZNUqQ4ZpUPJ27Oo36WKUEn8Vm7tuaq8=";
    private final long expiration = 3600000; // 1 hour

    public String generateToken(User user) {
        byte[] decodedSecret = Base64.getDecoder().decode(jwtSecret); // Decoding the Base64 secret

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("username", user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, decodedSecret)  // Pass the decoded secret here
                .compact();
    }
}