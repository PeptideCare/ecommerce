package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.order.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void mapToDomainEntityTest() {
        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(1L);

        ItemJpaEntity itemJpaEntity = new ItemJpaEntity();
        itemJpaEntity.setSeq(2L);

        OrderJpaEntity orderJpaEntity = new OrderJpaEntity();
        orderJpaEntity.setItemJpaEntity(itemJpaEntity);
        orderJpaEntity.setMemberJpaEntity(memberJpaEntity);
        orderJpaEntity.setSeq(3L);
        orderJpaEntity.setCount(100);
        orderJpaEntity.setSumPrice(100000L);

        Order order = orderMapper.mapToDomainEntity(orderJpaEntity);

        assertThat(order.getSeq().getValue(), is(equalTo(3L)));
        assertThat(order.getItemSeq().getValue(), is(equalTo(2L)));
        assertThat(order.getMemberSeq().getValue(), is(equalTo(1L)));
        assertThat(order.getCount(), is(equalTo(100)));
        assertThat(order.getSumPrice(), is(equalTo(100000L)));
    }
}
