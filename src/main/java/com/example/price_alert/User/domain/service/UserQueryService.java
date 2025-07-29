package com.example.price_alert.User.domain.service;

import com.example.price_alert.User.domain.entity.User;
import com.example.price_alert.User.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    /**
     * ID로 유저를 찾습니다.
     * @param id 유저의 고유 ID
     * @return 찾아낸 유저
     * @throws IllegalArgumentException 해당 ID의 유저가 없을 경우
     */
    @Transactional(readOnly = true) // 데이터를 변경하지 않는 조회 전용 메소드에는 readOnly = true 추천
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다: " + id));
    }

    /**
     * 이메일로 유저를 찾습니다.
     * @param email 유저의 이메일
     * @return 찾아낸 유저
     * @throws IllegalArgumentException 해당 이메일의 유저가 없을 경우
     */
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일의 유저를 찾을 수 없습니다: " + email));
    }

    // UserQueryService.java
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        // findByEmail은 Optional<User>를 반환하므로, isPresent()로 존재 여부를 확인할 수 있습니다.
        return userRepository.findByEmail(email).isPresent();
    }
}
