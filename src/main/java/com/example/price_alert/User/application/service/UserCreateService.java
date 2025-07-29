package com.example.price_alert.User.application.service;

import com.example.price_alert.User.application.dto.request.UserRequest;
import com.example.price_alert.User.domain.entity.User;
import com.example.price_alert.User.domain.service.UserQueryService;
import com.example.price_alert.User.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserSaveService userSaveService;
    private final UserQueryService userQueryService;
    private final PasswordEncoder passwordEncoder;


    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        String email = userCreateRequest.getEmail();
        String password = userCreateRequest.getPassword();

        // 1. UserQueryService를 이용한 이메일 중복 확인
        if (userQueryService.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 2. 비밀번호 암호화 및 객체 생성
        String encodedPassword = passwordEncoder.encode(userCreateRequest.getPassword());
        User userToSave = User.builder()
                .email(email)
                .password(encodedPassword)
                .build();

        // 3. 저장 위임
        userSaveService.saveUser(userToSave);
    }
}
