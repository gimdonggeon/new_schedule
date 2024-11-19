package com.kdg.schedulewithjpa.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final String userName;
    private final String email;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public SignUpResponseDto(String userName, String email, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.userName = userName;
        this.email = email;
        this.createdAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
