package com.gongbu.ecommerce.order.application.port.out;

import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;

public interface OrderPort {
    void order(OrderJpaEntity orderJpaEntity);


}
