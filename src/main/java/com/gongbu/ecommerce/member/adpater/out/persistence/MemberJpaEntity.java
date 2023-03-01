package com.gongbu.ecommerce.member.adpater.out.persistence;

import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;
import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "memberJpaEntity")
    private List<BasketJpaEntity> basketJpaEntityList;

    @OneToMany(mappedBy = "memberJpaEntity")
    private List<OrderJpaEntity> orderJpaEntityList;
}
