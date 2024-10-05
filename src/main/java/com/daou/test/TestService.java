package com.daou.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final UserRepository userRepository;

    public User login(Login login) {
        var userId = login.getId();

        // 1. id를 통해 해당 엔티티 불러오기
        var user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        // 2. passwordEncoder match()를 통해 참 거짓 판별

        // id와 pwd 정보는 반환 안함
        user.setUserId(null);
        user.setEncodedPwd(null);

        return user;
    }

    public User signup(Signup signup) {
        return User.builder()
                .nickname(signup.getNickname())
                .userId(signup.getId())
                .encodedPwd(signup.getPassword())
                .build();
    }
}
