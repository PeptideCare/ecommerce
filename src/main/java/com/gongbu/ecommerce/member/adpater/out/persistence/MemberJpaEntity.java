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
    private Long seq;

    private String memberId;
    private String memberPw;
    private String memberType;
    private Long myPoint;
}
