package com.example.price_alert.User.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 활성화
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @CreatedDate // 엔티티 생성 시 자동으로 현재 시간 저장
    @Column(updatable = false) // 생성 시간은 수정되면 안 되므로 추가
    private LocalDateTime createdTime; // 필드명은 camelCase로 변경 (create_time -> createdTime)

    // 생성자를 통해 직접 생성 시간을 주입할 필요가 없어짐
    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}