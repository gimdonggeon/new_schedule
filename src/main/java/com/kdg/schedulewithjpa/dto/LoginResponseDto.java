package com.kdg.schedulewithjpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

    private String name;
    private String email;

    public LoginResponseDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
