package com.gongbu.ecommerce.member.application.port.out;

import com.gongbu.ecommerce.member.domain.Member;

public interface LoadMemberPort {
    Member loadMember(Member.MemberSeq memberSeq);
}
