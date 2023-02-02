package com.gongbu.ecommerce.member.adpater.in.web;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String memberId;
    private String memberPw;
    private String memberType;


    public MemberJpaEntity mapToJpaEntity() {
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .memberId(memberId)
                .memberPw(memberPw)
                .memberType(memberType)
                .build();

        return memberJpaEntity;
    }
}
