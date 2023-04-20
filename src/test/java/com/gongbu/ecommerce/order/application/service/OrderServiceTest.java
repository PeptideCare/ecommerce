package com.gongbu.ecommerce.order.application.service;
import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.order.adapter.in.web.OrderRequest;
import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;
import com.gongbu.ecommerce.order.application.port.out.OrderPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;
    @Mock
    ItemPort itemPort;
    @Mock
    AccessMemberPort accessMemberPort;
    @Mock
    OrderPort orderPort;

    @Test
    public void orderTest() {
        OrderRequest orderRequest = OrderRequest.builder()
                .memberSeq(1L)
                .itemSeq(2L)
                .build();

        ItemJpaEntity itemJpaEntity = new ItemJpaEntity();
        itemJpaEntity.setSeq(2L);

        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(1L);
        memberJpaEntity.setMyPoint(10L);

        OrderJpaEntity orderJpaEntity = new OrderJpaEntity();
        orderJpaEntity.setSeq(3L);

        when(itemPort.loadItemJpaEntity(orderRequest.getItemSeq())).thenReturn(itemJpaEntity);
        when(accessMemberPort.loadMemberJpaEntity(orderRequest.getMemberSeq())).thenReturn(memberJpaEntity);

        OrderJpaEntity findOrderJpaEntity = orderRequest.mapToJpaEntity(memberJpaEntity, itemJpaEntity);
        when(orderPort.order(findOrderJpaEntity)).thenReturn(3L);

        Long seq = orderService.order(orderRequest);

        assertThat(seq, is(equalTo(3L)));
    }


}
