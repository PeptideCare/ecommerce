package com.gongbu.ecommerce.member.application.port.out;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.domain.Member;

public interface AccessMemberPort {
    Member loadMember(String memberId);

    Long insertMember(MemberJpaEntity memberJpaEntity);
}
