package com.gongbu.ecommerce.member.application.service;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberPersistentAdapter;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import com.gongbu.ecommerce.member.domain.MemberType;
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
public class AccessServiceTest {

    @Mock
    AccessMemberPort accessMemberPort;

    @InjectMocks
    AccessService accessService;

    @Test
    @DisplayName("로그인 테스트")
    public void loginTest() throws Exception {
        LoginRequest loginRequest = LoginRequest.builder()
                .memberId("testId")
                .memberPw("1234")
                .build();
        Member member = Member.builder()
                .seq(new Member.MemberSeq(1L))
                .memberId("testId")
                .memberPw("1234")
                .memberType(MemberType.admin)
                .myPoint(120L)
                .build();

        when(accessMemberPort.loadMember("testId")).thenReturn(member);
        Long seq = accessService.login(loginRequest);
        assertThat(seq, is(equalTo(1L)));
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void registerTest() throws Exception {
        RegisterRequest registerRequest = RegisterRequest.builder()
                .memberId("test")
                .memberPw("1234")
                .memberType("admin")
                .build();
        MemberJpaEntity memberJpaEntity = registerRequest.mapToJpaEntity();

        when(accessMemberPort.insertMember(memberJpaEntity)).thenReturn(1L);

        Long seq = accessService.register(registerRequest);
        assertThat(seq, is(equalTo(1L)));
    }
}
