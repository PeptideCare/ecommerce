package com.gongbu.ecommerce.member.application.port.in;

import com.gongbu.ecommerce.member.domain.Member;

public interface AccessUseCase {

    void login(Member member);

    void register(Member member);

}
