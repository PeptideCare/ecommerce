package com.gongbu.ecommerce.member.adpater.out.persistence;

import com.gongbu.ecommerce.member.domain.Member;
import com.gongbu.ecommerce.member.domain.MemberType;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    Member mapToDomainEntity(MemberJpaEntity memberJpaEntity) {

        MemberType memberType = null;
        if ("admin".equals(memberJpaEntity.getMemberType())) {
            memberType = MemberType.admin;
        } else {
            memberType = MemberType.user;
        }

        Member member = Member.builder()
                .seq(new Member.MemberSeq(memberJpaEntity.getSeq()))
                .memberId(memberJpaEntity.getMemberId())
                .memberPw(memberJpaEntity.getMemberPw())
                .memberType(memberType)
                .myPoint(memberJpaEntity.getMyPoint())
                .build();

        return member;
    }

    MemberJpaEntity mapToJpaEntity(Member member) {
        String memberType = null;
        if ("admin".equals(member.getMemberType())) {
            memberType = "admin";
        } else {
            memberType = "user";
        }

        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .seq(member.getSeq().getValue())
                .memberId(member.getMemberId())
                .memberPw(member.getMemberPw())
                .memberType(memberType)
                .myPoint(member.getMyPoint())
                .build();

        return memberJpaEntity;
    }

}
