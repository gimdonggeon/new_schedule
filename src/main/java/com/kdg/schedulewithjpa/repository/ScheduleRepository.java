package com.kdg.schedulewithjpa.repository;

import com.kdg.schedulewithjpa.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByUserId(Long userId);
    Optional<Schedule> findByIdAndUserId(Long scheduleId, Long userId);
}
