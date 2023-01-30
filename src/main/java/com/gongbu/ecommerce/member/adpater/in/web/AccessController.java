package com.gongbu.ecommerce.member.adpater.in.web;

import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessUseCase accessUseCase;

    // 로그인
    @PostMapping("/ecommnerce/login")
    public void login(
            @RequestBody LoginRequest loginRequest) {
        accessUseCase.login(loginRequest);
    }



}
