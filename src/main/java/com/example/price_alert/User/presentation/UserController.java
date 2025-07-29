package com.example.price_alert.User.presentation;

import com.example.price_alert.User.application.dto.request.UserRequest;
import com.example.price_alert.User.application.dto.response.UserResponse;
import com.example.price_alert.User.application.service.UserCreateService;
import com.example.price_alert.User.application.service.UserGetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserCreateService userCreateService;
    private final UserGetService userGetService;

    /**
     * 사용자 회원가입 API
     * @param createRequest DTO (email, password)
     * @return 201 Created
     */
    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest.UserCreateRequest createRequest) {
        userCreateService.createUser(createRequest);
        // 생성 성공 시, HTTP 201 Created 상태 코드를 반환
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 사용자 ID로 정보 조회 API
     * @param userId 사용자의 고유 ID
     * @return 200 OK, 사용자 정보 DTO
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse.UserInfoResponse> getUserById(@PathVariable Long userId) {
        UserResponse.UserInfoResponse userInfo = userGetService.getUserInfoById(userId);
        // 조회 성공 시, HTTP 200 OK 상태 코드와 사용자 정보를 반환
        return ResponseEntity.ok(userInfo);
    }

    /**
     * 사용자 이메일로 정보 조회 API
     * @param email 사용자의 이메일
     * @return 200 OK, 사용자 정보 DTO
     */
    @GetMapping("/by-email") // /api/users/by-email?email=test@example.com
    public ResponseEntity<UserResponse.UserInfoResponse> getUserByEmail(@RequestParam String email) {
        UserResponse.UserInfoResponse userInfo = userGetService.getUserInfoByEmail(email);
        return ResponseEntity.ok(userInfo);
    }

}
