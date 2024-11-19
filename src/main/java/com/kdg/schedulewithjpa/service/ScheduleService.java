package com.kdg.schedulewithjpa.service;

import com.kdg.schedulewithjpa.entity.Schedule;
import com.kdg.schedulewithjpa.entity.User;
import com.kdg.schedulewithjpa.repository.ScheduleRepository;
import com.kdg.schedulewithjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public Schedule createSchedule(Long userId, String title, String contents) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Schedule schedule = new Schedule(title, contents, user);
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getSchedulesByUser(Long userId) {
        return scheduleRepository.findByUserId(userId);
    }

    public Schedule getSchedule(Long userId, Long scheduleId) {
        return scheduleRepository.findByIdAndUserId(scheduleId, userId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다."));
    }

    public Schedule updateSchedule(Long userId, Long scheduleId, String title, String contents) {
        Schedule schedule = scheduleRepository.findByIdAndUserId(scheduleId, userId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없거나 수정권한이 없습니다."));

        schedule.getTitle();
        schedule.getContents();
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long userId, Long scheduleId) {
        Schedule schedule = scheduleRepository.findByIdAndUserId(scheduleId, userId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없거나 이미 삭제된 일정입니다."));

        scheduleRepository.delete(schedule);
    }
}
