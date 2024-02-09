package com.example.employee.security;

import com.example.employee.model.UserModel;
import com.example.employee.repository.UserRepository;
import com.example.employee.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String reqToken = request.getHeader("Authorization");
        String jwtToken = "";
        if (reqToken != null && reqToken.startsWith("Bearer ")) {
            String finalToken = reqToken.substring(7);
            String username = jwtUtils.getUserNameFromJwtToken(finalToken);
            UserModel empDetails = userRepository.findByUserName(username);
            GrantedAuthority authority = new SimpleGrantedAuthority(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(empDetails, finalToken, Arrays.asList(authority));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }


}
