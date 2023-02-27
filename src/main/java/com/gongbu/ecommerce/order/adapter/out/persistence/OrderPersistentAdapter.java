package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.order.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderPersistentAdapter implements OrderPort {
    private final OrderRepository orderRepository;

    @Override
    public void order(OrderJpaEntity orderJpaEntity) {
        orderRepository.save(orderJpaEntity);
    }
}
