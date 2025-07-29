package com.example.price_alert.User.domain.service;

import com.example.price_alert.User.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserRepository userRepository;

    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다." +  userId);
        }

        userRepository.deleteById(userId);
    }
}
