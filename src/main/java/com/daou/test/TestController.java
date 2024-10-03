package com.daou.test;

import com.daou.response.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test/")
@RequiredArgsConstructor // 자동 DI
public class TestController {

    @GetMapping("test")
    public ResponseEntity test() {
        return ResponseEntity.builder().status(200).message("테스트 성공").data("테스트 성공").build();
    }
}
