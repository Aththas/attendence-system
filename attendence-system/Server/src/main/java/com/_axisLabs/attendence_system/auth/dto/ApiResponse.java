package com._axisLabs.attendence_system.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T>{
    private boolean success;
    private T data;
    private String msg;
    private String errorCode;
}
