package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.order.application.port.in.BasketUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasketController {
    private final BasketUseCase basketUseCase;

    @PostMapping("/ecommerce/basket")
    public void addBasket(
            @RequestBody BasketRequest basketRequest) {
        basketUseCase.addBasket(basketRequest);
    }
}
