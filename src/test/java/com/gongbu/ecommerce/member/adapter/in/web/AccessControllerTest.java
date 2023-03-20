package com.gongbu.ecommerce.member.adapter.in.web;

import com.gongbu.ecommerce.member.adpater.in.web.AccessController;
import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccessControllerTest {

    @InjectMocks
    AccessController accessController;

    @Mock
    AccessUseCase accessUseCase;

    @DisplayName("로그인 테스트")
    @Test
    void loginTest() throws Exception {
        LoginRequest loginRequest = LoginRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .build();
        Long memberSeq = accessController.login(loginRequest);
        Assertions.assertNotNull(memberSeq);
    }

    @DisplayName("회원가입 테스트")
    @Test
    void registerTest() throws Exception {
        RegisterRequest registerRequest = RegisterRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .memberType("admin")
                .build();
        Long memberSeq = accessController.register(registerRequest);
        Assertions.assertNotNull(memberSeq);
    }
}
