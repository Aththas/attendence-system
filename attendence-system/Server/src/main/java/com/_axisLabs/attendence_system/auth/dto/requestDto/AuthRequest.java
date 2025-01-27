package com._axisLabs.attendence_system.auth.dto.requestDto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
