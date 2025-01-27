package com._axisLabs.attendence_system.auth.controller;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import com._axisLabs.attendence_system.auth.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attendance-system/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> home(){
        return homeService.getUserDetails();
    }
}
