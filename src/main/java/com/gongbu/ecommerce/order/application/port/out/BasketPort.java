package com.gongbu.ecommerce.order.application.port.out;

import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;

public interface BasketPort {
    void addBasket(BasketJpaEntity basketJpaEntity);
}
