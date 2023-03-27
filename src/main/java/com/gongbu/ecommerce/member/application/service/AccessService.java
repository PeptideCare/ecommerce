package com.gongbu.ecommerce.member.application.service;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class AccessService implements AccessUseCase {

    private final AccessMemberPort accessMemberPort;

    @Override
    public Long login(LoginRequest loginRequest) throws Exception {
        Member findMember = accessMemberPort.loadMember(loginRequest.getMemberId());
        // 비밀번호 검증
        if (loginRequest.getMemberPw().equals(findMember.getMemberPw())) {
            System.out.println("login success");
            return findMember.getSeq().getValue();
        } else {
            System.out.println("password is wrong");
            throw new Exception();
        }
    }

    @Override
    public Long register(RegisterRequest registerRequest) throws Exception {
        MemberJpaEntity memberJpaEntity = registerRequest.mapToJpaEntity();
        Long memberSeq = accessMemberPort.insertMember(memberJpaEntity);
        if (memberSeq == null) {
            System.out.println("register fail");
            throw new Exception();

        } else {
            System.out.println("register success");
            return memberSeq;
        }
    }
}
