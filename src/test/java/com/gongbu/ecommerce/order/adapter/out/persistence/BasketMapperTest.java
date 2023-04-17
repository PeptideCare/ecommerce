package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.order.domain.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class BasketMapperTest {

    @Autowired
    BasketMapper basketMapper;

    @Test
    public void mapToDomainEntityTest() {
        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(1L);
        ItemJpaEntity itemJpaEntity = new ItemJpaEntity();
        itemJpaEntity.setSeq(2L);


        BasketJpaEntity basketJpaEntity = new BasketJpaEntity();
        basketJpaEntity.setSeq(3L);
        basketJpaEntity.setCount(100);
        basketJpaEntity.setMemberJpaEntity(memberJpaEntity);
        basketJpaEntity.setItemJpaEntity(itemJpaEntity);
        basketJpaEntity.setSumPrice(50000L);

        Basket basket = basketMapper.mapToDomainEntity(basketJpaEntity);

        assertThat(basket.getSeq().getValue(), is(equalTo(3L)));
        assertThat(basket.getSumPrice(), is(equalTo(50000L)));
        assertThat(basket.getItemSeq().getValue(), is(equalTo(2L)));
        assertThat(basket.getMemberSeq().getValue(), is(equalTo(1L)));
        assertThat(basket.getCount(), is(equalTo(100)));
    }
}
