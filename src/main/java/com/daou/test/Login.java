package com.daou.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
@Getter
@Builder
public class Login {
    private String id;
    private String password;
}
