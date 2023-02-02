package com.gongbu.ecommerce.member.application.service;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.adpater.in.web.RegisterRequest;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
public class AccessService implements AccessUseCase {

    private final AccessMemberPort accessMemberPort;

    @Override
    public void login(LoginRequest loginRequest) throws Exception {
        Member findMember = accessMemberPort.loadMember(loginRequest.getMemberId());
        if (loginRequest.getMemberPw().equals(findMember.getMemberPw())) {
            System.out.println("login success");
        } else {
            System.out.println("password is wrong");
            throw new Exception();
        }
    }

    @Override
    public void register(RegisterRequest registerRequest) throws Exception {

        // 존재 여부 체크
        Member findMember = accessMemberPort.loadMember(registerRequest.getMemberId());
        if (findMember != null) {
            System.out.println("already exist");
            throw new Exception();
        }

        MemberJpaEntity memberJpaEntity = registerRequest.mapToJpaEntity();
        Long memberSeq = accessMemberPort.insertMember(memberJpaEntity);
        if (memberSeq == null) {
            System.out.println("register fail");
            throw new Exception();

        } else {
            System.out.println("register success");
        }
    }
}
