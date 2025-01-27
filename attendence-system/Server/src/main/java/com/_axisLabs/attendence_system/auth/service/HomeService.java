package com._axisLabs.attendence_system.auth.service;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface HomeService {
    ResponseEntity<ApiResponse<?>> getUserDetails();
}
