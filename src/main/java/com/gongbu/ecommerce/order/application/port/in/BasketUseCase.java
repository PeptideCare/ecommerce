package com.gongbu.ecommerce.order.application.port.in;

import com.gongbu.ecommerce.order.adapter.in.web.BasketRequest;

public interface BasketUseCase {
    void addBasket(BasketRequest basketRequest);
}
