package com._axisLabs.attendence_system.auth.service.impl;

import com._axisLabs.attendence_system.auth.dto.ApiResponse;
import com._axisLabs.attendence_system.auth.dto.requestDto.AuthRequest;
import com._axisLabs.attendence_system.auth.dto.responseDto.AuthResponse;
import com._axisLabs.attendence_system.auth.service.AuthService;
import com._axisLabs.attendence_system.config.JwtService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    @Value("${user.file.path}")
    private String FILE_PATH;

    private Map<String, String> userDetails;

    @PostConstruct
    private void init() {
        this.userDetails = loadUserDetailsFromFile();
    }

    public Map<String, String> loadUserDetailsFromFile() {
        Map<String, String> userDataMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(" ");
                if(data.length == 2){
                    userDataMap.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataMap;
    }

    @Override
    public ResponseEntity<ApiResponse<?>> authentication(AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        try{
            if(userDetails.containsKey(username) && userDetails.get(username).equals(password)){
                final String accessToken = jwtService.generateToken(authRequest);

                AuthResponse authResponse = new AuthResponse();
                authResponse.setAccessToken(accessToken);

                log.info("Authentication Success for user: " + username);
                return new ResponseEntity<>(
                        new ApiResponse<>(true, authResponse, "Authentication Success", null)
                        , HttpStatus.OK);
            }

            log.error("Authentication Failed");
            return new ResponseEntity<>(
                    new ApiResponse<>(false, null, "Authentication Failed", "401")
                    , HttpStatus.OK);

        }catch (Exception e){
            log.error("Server Side Error: " + e);
            return new ResponseEntity<>(
                    new ApiResponse<>(false, null, "Server Error", "500")
                    , HttpStatus.OK);
        }

    }
}
