package com.gongbu.ecommerce.member.adpater.out.persistence;

import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class MemberPersistentAdapter implements AccessMemberPort {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(Member.MemberSeq memberSeq) {
        //todo exception
        MemberJpaEntity memberJpaEntity = memberRepository.findById(memberSeq.getValue()).
                orElseThrow(EntityNotFoundException::new);

        return memberMapper.mapToDomainEntity(memberJpaEntity);

    }

    @Override
    public Long insertMember(Member member) {
        MemberJpaEntity memberJpaEntity = memberMapper.mapToJpaEntity(member);
        MemberJpaEntity savedMemberJpaEntity = memberRepository.save(memberJpaEntity);
        return savedMemberJpaEntity.getSeq();
    }
}
