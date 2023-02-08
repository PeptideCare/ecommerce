package com.gongbu.ecommerce.member.adpater.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJpaEntity {

    @Id
    @GeneratedValue
    private Long seq; // PK

    private String memberId; // 회원 ID
    private String memberPw; // 비밀번호
    private String memberType; // 회원 타입
    private Long myPoint; // 포인트
}
