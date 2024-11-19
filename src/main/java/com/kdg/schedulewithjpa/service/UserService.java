package com.kdg.schedulewithjpa.service;

import com.kdg.schedulewithjpa.dto.SignUpResponseDto;
import com.kdg.schedulewithjpa.entity.User;
import com.kdg.schedulewithjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User newUser = new User(userName, email, password);
        User savedUser = userRepository.save(newUser);

        return new SignUpResponseDto(savedUser.getName(), savedUser.getEmail(), savedUser.getCreatedAt(), savedUser.getModifiedAt());
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
        user.updatePassword(newPassword);
        return userRepository.save(user);
    }
}