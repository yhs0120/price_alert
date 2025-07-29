package com.example.price_alert.User.application.mapper;

import com.example.price_alert.User.application.dto.request.UserRequest;
import com.example.price_alert.User.application.dto.response.UserResponse;
import com.example.price_alert.User.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    // UserCreateRequest DTO -> User Entity 변환
    public static User mapToUser(UserRequest.UserCreateRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword()) // 서비스에서 암호화 필요
                .build();
    }

    // Entity를 DTO로 변환하는 정적 팩토리 메서드
    public static UserResponse.UserInfoResponse mapToUserResponse(User user) {
        return UserResponse.UserInfoResponse.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .createdTime(user.getCreatedTime())
                .build();
    }
}
