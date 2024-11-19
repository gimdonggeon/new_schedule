package com.kdg.schedulewithjpa.controller;

import com.kdg.schedulewithjpa.dto.CreateScheduleRequestDto;
import com.kdg.schedulewithjpa.entity.Schedule;
import com.kdg.schedulewithjpa.entity.User;
import com.kdg.schedulewithjpa.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/create")
    public ResponseEntity<Schedule> createSchedule(@RequestBody CreateScheduleRequestDto createScheduleRequestDto, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Schedule schedule = scheduleService.createSchedule(user.getId(),
                createScheduleRequestDto.getTitle(), createScheduleRequestDto.getContents());

        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedules(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Schedule> schedules = scheduleService.getSchedulesByUser(user.getId());
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<Schedule> getschedule(@PathVariable Long scheduleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Schedule schedule = scheduleService.getSchedule(user.getId(), scheduleId);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long scheduleId,
                                                   @RequestBody CreateScheduleRequestDto createScheduleRequestDto, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Schedule schedule = scheduleService.updateSchedule(user.getId(), scheduleId,
                createScheduleRequestDto.getTitle(), createScheduleRequestDto.getContents());
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        scheduleService.deleteSchedule(user.getId(), scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}