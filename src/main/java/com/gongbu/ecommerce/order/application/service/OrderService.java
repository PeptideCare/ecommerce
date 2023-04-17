package com.gongbu.ecommerce.order.application.service;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.order.adapter.in.web.OrderRequest;
import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;
import com.gongbu.ecommerce.order.application.port.in.OrderUseCase;
import com.gongbu.ecommerce.order.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {
    private final OrderPort orderPort;
    private final AccessMemberPort accessMemberPort;
    private final ItemPort itemPort;

    @Override
    public Long order(OrderRequest orderRequest) {
        ItemJpaEntity findItemJpaEntity = itemPort.loadItemJpaEntity(orderRequest.getItemSeq());
        MemberJpaEntity findMemberJpaEntity = accessMemberPort.loadMemberJpaEntity(orderRequest.getMemberSeq());
        OrderJpaEntity orderJpaEntity = orderRequest.mapToJpaEntity(findMemberJpaEntity, findItemJpaEntity);

        // 구매 포인트 10점 추가
        findMemberJpaEntity.setMyPoint(findMemberJpaEntity.getMyPoint() + 10);

        return orderPort.order(orderJpaEntity);
    }
}
