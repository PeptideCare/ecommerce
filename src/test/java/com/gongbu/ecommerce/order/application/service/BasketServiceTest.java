package com.gongbu.ecommerce.order.application.service;

import com.gongbu.ecommerce.order.application.port.out.BasketPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    BasketPort basketPort;

    @Test
    public void addBasketTest() {

    }
}
