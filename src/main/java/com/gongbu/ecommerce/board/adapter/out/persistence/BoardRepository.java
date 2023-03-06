package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardJpaEntity, Long> {

    @Query("select m from MemberJpaEntity m " +
            "where m.memberId = :memberId")
    Optional<MemberJpaEntity> update(
            @Param("memberId") String memberId);
}
