package com._axisLabs.attendence_system.auth.service;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import com._axisLabs.attendence_system.auth.dto.requestDto.AuthRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<ApiResponse<?>> authentication(AuthRequest authRequest);
}
