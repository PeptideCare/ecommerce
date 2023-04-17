package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.order.application.port.in.BasketUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BasketControllerTest {

    @InjectMocks
    BasketController basketController;

    @Mock
    BasketUseCase basketUseCase;

    @Test
    @DisplayName("장바구니 추가 테스트")
    public void addBasketTest() {
        BasketRequest basketRequest = BasketRequest.builder()
                .memberSeq(1L)
                .itemSeq(2L)
                .sumPrice(10000L)
                .count(200)
                .build();

        when(basketUseCase.addBasket(basketRequest)).thenReturn(1L);
        Long seq = basketController.addBasket(basketRequest);
        assertThat(seq, is(equalTo(1L)));
    }
}
