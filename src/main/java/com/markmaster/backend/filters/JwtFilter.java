package com.markmaster.backend.filters;

import com.markmaster.backend.service.JWT.JWTService;
import com.markmaster.backend.service.User.UserServiceDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;
    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            token = bearerToken.substring(7);
            username = jwtService.getUsername(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = (UserDetails) applicationContext.getBean(UserServiceDetailsService.class).loadUserByUsername(username);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
