package com._axisLabs.attendence_system.auth.controller;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import com._axisLabs.attendence_system.auth.dto.requestDto.AuthRequest;
import com._axisLabs.attendence_system.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance-system/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> auth(@RequestBody AuthRequest authRequest){
        return authService.authentication(authRequest);
    }
}
