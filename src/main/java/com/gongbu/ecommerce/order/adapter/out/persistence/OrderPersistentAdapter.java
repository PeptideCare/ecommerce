package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.order.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderPersistentAdapter implements OrderPort {
    private final OrderRepository orderRepository;

    @Override
    public Long order(OrderJpaEntity orderJpaEntity) {
        OrderJpaEntity savedOrderJpaEntity = orderRepository.save(orderJpaEntity);
        return savedOrderJpaEntity.getSeq();
    }
}
