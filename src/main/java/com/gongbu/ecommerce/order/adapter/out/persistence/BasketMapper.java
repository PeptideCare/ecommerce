package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.member.domain.Member;
import com.gongbu.ecommerce.order.domain.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketMapper {
    Basket mapToDomainEntity(BasketJpaEntity basketJpaEntity) {
        Basket basket = Basket.builder()
                .seq(new Basket.BasketSeq(basketJpaEntity.getSeq()))
                .count(basketJpaEntity.getCount())
                .sumPrice(basketJpaEntity.getSumPrice())
                .itemSeq(new Item.ItemSeq(basketJpaEntity.getItemJpaEntity().getSeq()))
                .memberSeq(new Member.MemberSeq(basketJpaEntity.getMemberJpaEntity().getSeq()))
                .build();
        return basket;
    }
}
