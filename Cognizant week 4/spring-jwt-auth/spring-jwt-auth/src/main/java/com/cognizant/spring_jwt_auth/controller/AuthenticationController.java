package com.cognizant.spring_jwt_auth.controller;

import com.cognizant.spring_jwt_auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return "Missing or invalid Authorization header.";
        }

        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);

        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        if (username.equals("user") && password.equals("pwd")) {
            String token = jwtUtil.generateToken(username);
            return "{\"token\": \"" + token + "\"}";
        } else {
            return "Invalid credentials";
        }
    }
}
