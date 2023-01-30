package com.gongbu.ecommerce.member.application.service;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
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
    public void login(LoginRequest loginRequest) {
        Member findMember = accessMemberPort.loadMember(loginRequest.getMemberId());
        if (loginRequest.getMemberPw().equals(findMember.getMemberPw())) {
            System.out.println("login success");
        } else {
            System.out.println("password is wrong");
        }
    }

    @Override
    public void register(Member member) {
        Long memberSeq = accessMemberPort.insertMember(member);
        if (memberSeq == null) {
            System.out.println("register fail");
        } else {
            System.out.println("register success");
        }
    }
}
