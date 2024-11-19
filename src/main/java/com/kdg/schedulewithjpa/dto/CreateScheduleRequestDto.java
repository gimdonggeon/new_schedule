package com.kdg.schedulewithjpa.dto;

import com.kdg.schedulewithjpa.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScheduleRequestDto {

    private final String title;

    private final String contents;

    public CreateScheduleRequestDto(User name, String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
