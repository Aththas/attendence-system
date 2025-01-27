package com._axisLabs.attendence_system.auth.service.impl;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import com._axisLabs.attendence_system.auth.service.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public ResponseEntity<ApiResponse<?>> getUserDetails() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(
                new ApiResponse<>(true, username, "Username Retrieved", null)
                , HttpStatus.OK);
    }
}
