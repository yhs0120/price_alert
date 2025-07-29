package com.example.price_alert.User.application.service;

import com.example.price_alert.User.application.dto.response.UserResponse;
import com.example.price_alert.User.application.mapper.UserMapper;
import com.example.price_alert.User.domain.entity.User;
import com.example.price_alert.User.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserQueryService userQueryService;

    @Transactional(readOnly = true)
    public UserResponse.UserInfoResponse getUserInfoById(Long userId) {
        User foundUser = userQueryService.findUserById(userId);
        return UserMapper.mapToUserResponse(foundUser);
    }

    @Transactional(readOnly = true)
    public UserResponse.UserInfoResponse getUserInfoByEmail(String email) {
        User userByEmail = userQueryService.findUserByEmail(email);
        return UserMapper.mapToUserResponse(userByEmail);
    }
}
