package com.gongbu.ecommerce.order.application.port.in;

import com.gongbu.ecommerce.order.adapter.in.web.OrderRequest;

public interface OrderUseCase {
    Long order(OrderRequest orderRequest);
}
