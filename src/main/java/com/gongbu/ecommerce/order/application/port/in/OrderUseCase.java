package com.gongbu.ecommerce.order.application.port.in;

import com.gongbu.ecommerce.order.adapter.in.web.OrderRequest;

public interface OrderUseCase {
    void order(OrderRequest orderRequest);
}
