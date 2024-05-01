package com.example.SpringMongoPoject.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Document
@RequiredArgsConstructor
public class JWTAutonticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(
           @NotNull HttpServletRequest request,
           @NotNull HttpServletResponse response,
           @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authentication");
        final String jwt;
        final String username;
        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request,response);
            return;
        }
        jwt = authHeader.substring(7) ;
        username = jwtService.extractUsername(jwt);
    }
}
