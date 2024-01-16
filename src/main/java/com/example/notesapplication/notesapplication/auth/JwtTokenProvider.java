package com.example.notesapplication.notesapplication.auth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    public String generateToken(String username, String userPassword) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000); // Token valid for 1 hour

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, userPassword)
                .compact();
    }
}
