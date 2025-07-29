package com.example.price_alert.User.application.dto.response;

import com.example.price_alert.User.domain.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserResponse {

    @Getter
    @NoArgsConstructor
    public static class UserInfoResponse {

        private Long userId;
        private String email;
        private LocalDateTime createdTime;

        // private 생성자로 외부에서 직접 생성을 막고, 정적 팩토리 메서드 사용을 유도
        @Builder
        private UserInfoResponse(Long userId, String email, LocalDateTime createdTime) {
            this.userId = userId;
            this.email = email;
            this.createdTime = createdTime;
        }


    }
}