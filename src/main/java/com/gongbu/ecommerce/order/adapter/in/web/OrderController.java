package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.order.application.port.in.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderUseCase orderUseCase;

    @PostMapping("/ecommerce/order")
    public void order(
            @RequestBody OrderRequest orderRequest) {
        orderUseCase.order(orderRequest);
    }
}
