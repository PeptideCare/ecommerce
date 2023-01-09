package com.gongbu.ecommerce.member.adpater.out.persistence;

import com.gongbu.ecommerce.member.application.port.out.LoadMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class MemberPersistentAdapter implements LoadMemberPort {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(Member.MemberSeq memberSeq) {
        //todo exception
        MemberJpaEntity memberJpaEntity = memberRepository.findById(memberSeq.getValue()).
                orElseThrow(EntityNotFoundException::new);

        return memberMapper.mapToDomainEntity(memberJpaEntity);

    }
}
