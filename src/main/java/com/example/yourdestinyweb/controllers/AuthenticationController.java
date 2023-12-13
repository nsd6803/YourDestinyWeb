package com.example.yourdestinyweb.controllers;


import com.example.yourdestinyweb.dao.RedisEntityDao;
import com.example.yourdestinyweb.dao.request.SignInRequest;
import com.example.yourdestinyweb.dao.request.SignUpRequest;
import com.example.yourdestinyweb.dao.response.JwtAuthenticationResponse;
import com.example.yourdestinyweb.models.RedisEntity;
import com.example.yourdestinyweb.services.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private RedisEntityDao redisEntityDao;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> singUp(@RequestBody SignUpRequest request, Principal principal){
        JwtAuthenticationResponse response = authenticationService.signUp(request);
        redisEntityDao.save(RedisEntity.builder().userEmail(request.getEmail()).token(response.getToken()).build());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> singIn(@RequestBody SignInRequest request){
        JwtAuthenticationResponse response = authenticationService.signIn(request);
        redisEntityDao.save(RedisEntity.builder().userEmail(request.getEmail()).token(response.getToken()).build());
        return ResponseEntity.ok(response);
    }
}
