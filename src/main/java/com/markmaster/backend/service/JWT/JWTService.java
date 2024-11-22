package com.markmaster.backend.service.JWT;

import com.markmaster.backend.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JWTService {
    private String secret;

    public JWTService() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey key = keyGen.generateKey();
            this.secret = Base64.getEncoder().encodeToString(key.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        return Jwts.builder().claims().add(claims).subject(username).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() * 60 * 60 * 60)).and().signWith(getKey()).compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> Resolver) {
        final Claims claims = extractAllClaims(token);
        return Resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
    }

    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return expirationDate(token).before(new Date());
    }

    private Date expirationDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
