package com.chathura.lapmart.auth_server.api;

import com.chathura.lapmart.auth_server.dto.request.RequestUserDto;
import com.chathura.lapmart.auth_server.service.UserService;
import com.chathura.lapmart.auth_server.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponseDto> registerUser(@RequestBody RequestUserDto dto){
        userService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto(201,"User created successfully",null),
                HttpStatus.CREATED
        );
    }
}
