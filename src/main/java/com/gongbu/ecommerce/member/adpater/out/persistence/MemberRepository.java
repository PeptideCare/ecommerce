package com.gongbu.ecommerce.member.adpater.out.persistence;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberJpaEntity, Long> {
    @Query("select m from MemberJpaEntity m " +
            "where m.memberId = :memberId")
    Optional<MemberJpaEntity> findByMemberId(
            @Param("memberId") String memberId);
}
