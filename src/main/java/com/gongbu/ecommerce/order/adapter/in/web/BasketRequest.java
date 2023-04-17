package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketRequest {
    private Long memberSeq; // member PK
    private Long itemSeq; // item PK
    private int count; // 주문 수량
    private Long sumPrice; // 주문 금액

    public BasketJpaEntity mapToJpaEntity(MemberJpaEntity memberJpaEntity, ItemJpaEntity itemJpaEntity) {
        BasketJpaEntity basketJpaEntity = BasketJpaEntity.builder()
                .count(this.getCount())
                .sumPrice(this.getSumPrice())
                .memberJpaEntity(memberJpaEntity)
                .itemJpaEntity(itemJpaEntity)
                .build();
        return basketJpaEntity;
    }
}
