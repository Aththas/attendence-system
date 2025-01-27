package com._axisLabs.attendence_system.auth.controller;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
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

    @GetMapping
    public ResponseEntity<ApiResponse<?>> home(){
        return new ResponseEntity<>(
                new ApiResponse<>(true, null, "HI", null)
        , HttpStatus.OK);
    }
}
