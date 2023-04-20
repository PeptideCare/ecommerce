package com.gongbu.ecommerce.order.application.service;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.order.adapter.in.web.BasketRequest;
import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;
import com.gongbu.ecommerce.order.application.port.out.BasketPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @InjectMocks
    BasketService basketService;
    @Mock
    AccessMemberPort accessMemberPort;
    @Mock
    ItemPort itemPort;
    @Mock
    BasketPort basketPort;

    @Test
    public void addBasketTest() {
        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(1L);
        memberJpaEntity.setMemberId("test");

        ItemJpaEntity itemJpaEntity = new ItemJpaEntity();
        itemJpaEntity.setSeq(2L);

        BasketRequest basketRequest = BasketRequest.builder()
                .memberSeq(1L)
                .itemSeq(2L)
                .build();

        BasketJpaEntity basketJpaEntity = new BasketJpaEntity();
        basketJpaEntity.setSeq(1L);
        basketJpaEntity.setMemberJpaEntity(memberJpaEntity);
        basketJpaEntity.setItemJpaEntity(itemJpaEntity);

        when(accessMemberPort.loadMemberJpaEntity(1L)).thenReturn(memberJpaEntity);
        when(itemPort.loadItemJpaEntity(basketRequest.getItemSeq())).thenReturn(itemJpaEntity);

        BasketJpaEntity findBasketJpaEntity = basketRequest.mapToJpaEntity(memberJpaEntity, itemJpaEntity);
        when(basketPort.addBasket(findBasketJpaEntity)).thenReturn(1L);

        Long seq = basketService.addBasket(basketRequest);

        assertThat(seq, is(equalTo(1L)));
    }
}
