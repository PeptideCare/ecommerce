package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.order.application.port.out.BasketPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BasketPersistentAdapter implements BasketPort {
    private final BasketRepository basketRepository;

    @Override
    public void addBasket(BasketJpaEntity basketJpaEntity) {
        basketRepository.save(basketJpaEntity);
    }
}
