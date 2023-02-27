package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Long memberSeq; // member PK
    private Long itemSeq; // item PK
    private int count; // 주문 수량
    private Long sumPrice; // 주문 금액
    private LocalDateTime date; // 주문 날짜

    public OrderJpaEntity mapToJpaEntity(MemberJpaEntity memberJpaEntity, ItemJpaEntity itemJpaEntity) {
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .memberJpaEntity(memberJpaEntity)
                .itemJpaEntity(itemJpaEntity)
                .count(this.getCount())
                .sumPrice(this.getSumPrice())
                .date(this.getDate())
                .build();
        return orderJpaEntity;
    }
}
