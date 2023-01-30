package com.gongbu.ecommerce.member.application.port.in;

import com.gongbu.ecommerce.member.adpater.in.web.LoginRequest;
import com.gongbu.ecommerce.member.domain.Member;

public interface AccessUseCase {

    void login(LoginRequest loginRequest);

    void register(Member member);

}
