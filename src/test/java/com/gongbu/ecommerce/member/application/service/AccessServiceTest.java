package com.gongbu.ecommerce.member.application.service;

import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberPersistentAdapter;
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
    MemberPersistentAdapter memberPersistentAdapter;

    @Test
    @DisplayName("로그인 테스트")
    public void loginTest() {
        boolean login = false;
        Member member = Member.builder()
                .seq(new Member.MemberSeq(1L))
                .memberId("test")
                .memberPw("1234")
                .memberType(MemberType.admin)
                .myPoint(120L)
                .build();

        when(memberPersistentAdapter.loadMember("test")).thenReturn(member);

        Member findMember = memberPersistentAdapter.loadMember("test");
        if (findMember.getMemberPw().equals("1234")) login = true;
        assertThat(login, is(equalTo(true)));
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void registerTest() {
        boolean register = false;
        RegisterRequest registerRequest = RegisterRequest.builder()
                .memberId("test")
                .memberPw("1234")
                .memberType("admin")
                .build();
        MemberJpaEntity memberJpaEntity = registerRequest.mapToJpaEntity();

        when(memberPersistentAdapter.insertMember(memberJpaEntity)).thenReturn(1L);

        Long seq = memberPersistentAdapter.insertMember(memberJpaEntity);
        if (seq != null) register = true;
        assertThat(register, is(equalTo(true)));
    }
}
