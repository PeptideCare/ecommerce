package com.gongbu.ecommerce.member.adpater.out.persistence;

import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
public class MemberPersistentAdapter implements AccessMemberPort {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    @Override
    public Member loadMember(String memberId) {
        MemberJpaEntity memberJpaEntity = memberRepository.findByMemberId(memberId).
                orElseThrow(EntityNotFoundException::new);

        return memberMapper.mapToDomainEntity(memberJpaEntity);

    }

    @Override
    public MemberJpaEntity loadMemberJpaEntity(Long memberSeq) {
        MemberJpaEntity memberJpaEntity = memberRepository.findById(memberSeq).
                orElseThrow(EntityNotFoundException::new);

        return memberJpaEntity;
    }

    @Override
    public Long insertMember(MemberJpaEntity memberJpaEntity) {
        MemberJpaEntity savedMemberJpaEntity = memberRepository.save(memberJpaEntity);
        return savedMemberJpaEntity.getSeq();
    }
}
