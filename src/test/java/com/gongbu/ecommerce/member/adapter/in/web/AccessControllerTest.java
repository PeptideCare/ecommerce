package com.gongbu.ecommerce.member.adapter.in.web;

import com.gongbu.ecommerce.member.adpater.in.web.AccessController;
import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import com.gongbu.ecommerce.member.application.service.AccessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class AccessControllerTest {

    @Mock
    AccessUseCase accessUseCase;

    @InjectMocks
    AccessController accessController;

    @DisplayName("로그인 테스트")
    @Test
    void loginTest() throws Exception {
        LoginRequest loginRequest = LoginRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .build();

        when(accessUseCase.login(loginRequest)).thenReturn(1L);

        Long seq = accessController.login(loginRequest);
        assertThat(seq, is(equalTo(1L)));
    }

    @DisplayName("회원가입 테스트")
    @Test
    void registerTest() throws Exception {
        RegisterRequest registerRequest = RegisterRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .memberType("admin")
                .build();

        when(accessUseCase.register(registerRequest)).thenReturn(1L);

        Long seq = accessController.register(registerRequest);

        assertThat(seq, is(equalTo(1L)));
    }
}
