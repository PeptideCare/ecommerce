package com.gongbu.ecommerce.order.adapter.in.web;

import com.gongbu.ecommerce.order.application.port.in.OrderUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    OrderUseCase orderUseCase;

    @InjectMocks
    OrderController orderController;

    @Test
    public void orderTest() {
        OrderRequest orderRequest = OrderRequest.builder()
                .memberSeq(1L)
                .count(100)
                .date(LocalDateTime.now())
                .itemSeq(2L)
                .sumPrice(50000L)
                .build();

        when(orderUseCase.order(orderRequest)).thenReturn(1L);
        Long seq = orderController.order(orderRequest);

        assertThat(seq, is(equalTo(1L)));
    }
}
