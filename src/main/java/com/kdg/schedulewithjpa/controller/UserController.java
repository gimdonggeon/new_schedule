package com.kdg.schedulewithjpa.controller;

import com.kdg.schedulewithjpa.dto.LoginRequestDto;
import com.kdg.schedulewithjpa.dto.LoginResponseDto;
import com.kdg.schedulewithjpa.dto.SignUpRequestDto;
import com.kdg.schedulewithjpa.dto.SignUpResponseDto;
import com.kdg.schedulewithjpa.entity.User;
import com.kdg.schedulewithjpa.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = userService.signUp(
                        requestDto.getUserName(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );
        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
        User user = userService.authenticateUser(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        if( user != null ) {
            session.setAttribute("user", user);
            return new ResponseEntity<>(new LoginResponseDto(user.getName(), user.getEmail()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
