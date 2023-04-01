package com.gongbu.ecommerce.member.adapter.in.web;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.application.service.AccessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccessControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    AccessService accessService;

    @DisplayName("로그인 테스트")
    @Test
    void loginTest() throws Exception {
        LoginRequest loginRequest = LoginRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .build();

        when(accessService.login(loginRequest)).thenReturn(1L);
        Long seq = accessService.login(loginRequest);
        assertThat(seq, is(equalTo(1L)));
    }

    @DisplayName("회원가입 테스트")
    @Test
    void registerTest() throws Exception {
        String registerRequest = "{\"memberId\" : \"testId\", \"memberPw\" : \"1234\", \"memberType\" : \"admin\"}";

        mockMvc.perform(post("/ecommerce/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerRequest))
                .andExpect(status().isOk());
    }
}
