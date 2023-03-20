package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK

    private int count; // 주문수량
    private Long sumPrice; // 주문 금액
    private LocalDateTime date; // 주문 시간

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberSeq")
    private MemberJpaEntity memberJpaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemSeq")
    private ItemJpaEntity itemJpaEntity;
}
