package com.gongbu.ecommerce.member.adapter.out.persistence;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.domain.Member;
import com.gongbu.ecommerce.member.domain.MemberType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class MemberMapperTest {

    @Test
    @DisplayName("Member Domain 매핑 테스트")
    public void mapToDomainEntityTest() {
        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(1L);
        memberJpaEntity.setMemberId("test");
        memberJpaEntity.setMemberPw("1234");
        memberJpaEntity.setMemberType("admin");
        memberJpaEntity.setMyPoint(120L);

        Member member = Member.builder()
                .seq(new Member.MemberSeq(memberJpaEntity.getSeq()))
                .memberId(memberJpaEntity.getMemberId())
                .memberPw(memberJpaEntity.getMemberPw())
                .memberType(MemberType.admin)
                .myPoint(memberJpaEntity.getMyPoint())
                .build();

        assertThat(member.getSeq().getValue(), is(equalTo(memberJpaEntity.getSeq())));
        assertThat(member.getMemberId(), is(equalTo(memberJpaEntity.getMemberId())));
        assertThat(member.getMemberPw(), is(equalTo(memberJpaEntity.getMemberPw())));
        assertThat(String.valueOf(member.getMemberType()), is(equalTo(memberJpaEntity.getMemberType())));
        assertThat(member.getMyPoint(), is(equalTo(memberJpaEntity.getMyPoint())));
    }
}
