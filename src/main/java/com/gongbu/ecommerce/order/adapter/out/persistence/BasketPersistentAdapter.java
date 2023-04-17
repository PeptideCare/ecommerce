package com.gongbu.ecommerce.order.adapter.out.persistence;

import com.gongbu.ecommerce.order.application.port.out.BasketPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BasketPersistentAdapter implements BasketPort {
    private final BasketRepository basketRepository;

    @Override
    public Long addBasket(BasketJpaEntity basketJpaEntity) {
        BasketJpaEntity savedBasketJpaEntity = basketRepository.save(basketJpaEntity);
        return savedBasketJpaEntity.getSeq();
    }
}
