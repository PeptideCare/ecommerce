package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.member.domain.Member;
import com.gongbu.ecommerce.order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    Order mapToDomainEntity(OrderJpaEntity orderJpaEntity) {
        Order order = Order.builder()
                .seq(new Order.OrderSeq(orderJpaEntity.getSeq()))
                .count(orderJpaEntity.getCount())
                .sumPrice(orderJpaEntity.getSumPrice())
                .date(orderJpaEntity.getDate())
                .memberSeq(new Member.MemberSeq(orderJpaEntity.getMemberJpaEntity().getSeq()))
                .itemSeq(new Item.ItemSeq(orderJpaEntity.getItemJpaEntity().getSeq()))
                .build();
        return order;
    }
}
