package com.gongbu.ecommerce.member.application.port.out;

import com.gongbu.ecommerce.member.domain.Member;

public interface AccessMemberPort {
    Member loadMember(Member.MemberSeq memberSeq);

    Long insertMember(Member member);
}
